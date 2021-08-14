package com.project.orange.controller.image;

import com.project.orange.entity.article.ArticleImages;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.user.Users;
import com.project.orange.service.article.ArticleImagesService;
import com.project.orange.service.article.ArticlesService;
import com.project.orange.service.challenge.ChallengeService;
import com.project.orange.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.project.orange.management.Constants.ImageRealPath;

@RestController
@RequestMapping("/api/image")
public class ImageHandleController {

    @Autowired
    private ArticleImagesService articleImagesService;

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChallengeService challengeService;

    @PostMapping("/article/save")
    private ResponseEntity<?> saveArticleImage(@RequestParam("image") MultipartFile[] images,
                                               @RequestParam("articleId") Long articleId) throws IOException {

        Map<String, String> response = new HashMap<>();
        if(!images[0].isEmpty()){
            List<String> savedImageNameList = new ArrayList<>();
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveDirectory = ImageRealPath + File.separator + today;

            File dir = new File(saveDirectory);
            if(!dir.exists()){
                dir.mkdir();
            }
            for(MultipartFile eachImage : images){
                String originalImageName = eachImage.getOriginalFilename();
                if(!originalImageName.isEmpty()){
                    String extension = originalImageName.substring(originalImageName.lastIndexOf('.'));
                    String saveImageName = UUID.randomUUID().toString() + extension;

                    eachImage.transferTo(new File(dir, saveImageName));
                    savedImageNameList.add(saveImageName);
                }
            }

            List<ArticleImages> articleImagesList = new ArrayList<>();
            for(String savedImage : savedImageNameList){
                ArticleImages articleImage = new ArticleImages();
                articleImage.setArticle(articlesService.selectOne(articleId).get());
                articleImage.setImagePath(savedImage);

                articleImagesList.add(articleImage);
            }
            articleImagesService.saveAll(articleImagesList);

            response.put("result", "success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("result", "failed");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/profile/save")
    private ResponseEntity<?> saveProfileImage(@RequestParam("image") MultipartFile[] images,
                                               @RequestParam("userId") Long userId) throws IOException {

        Map<String, String> response = new HashMap<>();
        System.out.println(images.length);
        if(images.length < 2) {
            if (!images[0].isEmpty()) {
                List<String> savedImageNameList = new ArrayList<>();
                String today = new SimpleDateFormat("yyMMdd").format(new Date());
                String saveDirectory = ImageRealPath + File.separator + today;

                File dir = new File(saveDirectory);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                for (MultipartFile eachImage : images) {
                    String originalImageName = eachImage.getOriginalFilename();
                    if (!originalImageName.isEmpty()) {
                        String extension = originalImageName.substring(originalImageName.lastIndexOf('.'));
                        String saveImageName = UUID.randomUUID().toString() + extension;

                        eachImage.transferTo(new File(dir, saveImageName));
                        savedImageNameList.add(saveImageName);
                    }
                }

                Users user = userService.selectAllByUserId(userId);
                user.setProfileImagePath(savedImageNameList.get(0));
                userService.updateById(userId, user);

                response.put("result", "success");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.put("result", "there is no image.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        else {
            response.put("result", "expected 1 image, received : " + images.length);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/challenge/save")
    private ResponseEntity<?> saveChallengeImage(@RequestParam("image") MultipartFile[] images,
                                               @RequestParam("challengeId") Long challengeId) throws IOException {

        Map<String, String> response = new HashMap<>();
        System.out.println(images.length);
        if(images.length < 2) {
            if (!images[0].isEmpty()) {
                List<String> savedImageNameList = new ArrayList<>();
                String today = new SimpleDateFormat("yyMMdd").format(new Date());
                String saveDirectory = ImageRealPath + File.separator + today;

                File dir = new File(saveDirectory);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                for (MultipartFile eachImage : images) {
                    String originalImageName = eachImage.getOriginalFilename();
                    if (!originalImageName.isEmpty()) {
                        String extension = originalImageName.substring(originalImageName.lastIndexOf('.'));
                        String saveImageName = UUID.randomUUID().toString() + extension;

                        eachImage.transferTo(new File(dir, saveImageName));
                        savedImageNameList.add(saveImageName);
                    }
                }

                Challenges challenge = challengeService.selectByChallengeId(challengeId).get();
                challenge.setImagePath(savedImageNameList.get(0));
                challengeService.save(challenge);

                response.put("result", "success");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.put("result", "there is no image.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        else {
            response.put("result", "expected 1 image, received : " + images.length);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }
}
