<template>
  <div class="text-center">
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">

          <v-btn icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-bell-ring-outline</v-icon>
          </v-btn>

      </template>
      <v-list>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
  export default {
    name: 'NotificationForm',
    data: () => ({
      items: [
        { title: '당신은 사랑받기 위해 태어난 사람 알림입니다 1' },
        { title: '당신은 사랑받기 위해 태어난 사람 알림입니다 2' },
        { title: '당신은 사랑받기 위해 태어난 사람 알림입니다 3' },
        { title: '당신은 사랑받기 위해 태어난 사람 알림입니다 4' },
      ],
    }),
  }
</script>