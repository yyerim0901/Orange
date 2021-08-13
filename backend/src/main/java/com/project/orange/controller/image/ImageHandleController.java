package com.project.orange.controller.image;

import com.project.orange.entity.article.ArticleImages;
import com.project.orange.service.article.ArticleImagesService;
import com.project.orange.service.article.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/save")
    private ResponseEntity<?> saveImage(@RequestParam("image") MultipartFile[] images,
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
}
