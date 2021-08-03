<template>
  <div>
    <ProfileForm />
    <ProfileTab />
  </div>
</template>

<script>
import ProfileForm from '@/components/user/ProfileForm.vue'
import ProfileTab from '@/components/user/ProfileTab.vue'
export default {
  name: 'Profile',
  components: {
    ProfileForm,
    ProfileTab,
  }
}
</script>

<style>

</style>