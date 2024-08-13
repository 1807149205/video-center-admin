import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useAsideMenuStore = defineStore('asideMenu', () => {
  
    const asideMenuConfig = ref([
        {
            key: 'videoSub',
            text: '视频',
            children: [
              {
                key: 'videoEdit',
                text: '视频编辑',
              },
              {
                key: 'cateogryEdit',
                text: '视频分类编辑'
              },
            ]
        },
        {
          key: 'userSub',
          text: '用户',
          children: [
            {
              key: 'userEdit',
              text: '用户编辑'
            }
          ]
        }
    ])

    const asideMenuSelectKey = ref('videoEdit');

  return { asideMenuConfig, asideMenuSelectKey }
})
