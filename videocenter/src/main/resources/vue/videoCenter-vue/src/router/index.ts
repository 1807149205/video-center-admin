import UserEditView from '@/views/UserEditView.vue'
import VideoCategoryEditView from '@/views/VideoCategoryEditView.vue'
import VideoEditView from '@/views/VideoEditView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/videoEdit'
    },
    {
      path: '/videoEdit',
      component: VideoEditView
    },
    {
      path: '/cateogryEdit',
      component: VideoCategoryEditView
    },
    {
      path: '/userEdit',
      component: UserEditView
    }
  ]
})

export default router
