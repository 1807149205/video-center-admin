<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
import type { ItemType } from 'ant-design-vue';
import router from '@/router';
const topMenuSelect = ref<string[]>(['2']);
const asideMenuSelect = ref<string[]>(['videoEdit']);
const openKeys = ref<string[]>(['videoSub']);
const breadCrumbItem = ref<string[]>(['视频','视频编辑']);

const asideMenuConfig: ItemType[] = [
    {
        key: 'videoSub',
        label: '视频',
        children: [
          {
            key: 'videoEdit',
            label: '视频编辑',
          },
          {
            key: 'cateogryEdit',
            label: '视频分类编辑'
          },
        ]
    },
    {
      key: 'userSub',
      label: '用户',
      children: [
        {
          key: 'userEdit',
          label: '用户编辑'
        }
      ]
    }
]

const menuItemClickHandle = (option) => {
  router.push(option.key);
  let index = 0;
  breadCrumbItem.value = [];
  const path = option.keyPath;
  const deep = (config) => {
      if (index >= path.length) {
        return ;
      }
      for (const item of config) {
        if (item.key === path[index]) {
          breadCrumbItem.value[index++] = item.label;
          deep(item.children);
        }
      }
  }
  deep(asideMenuConfig);
}

const initPage = async () => {

}

onMounted(async () => {
    await initPage();
})
</script>

<template>
   <a-layout style="display: flex; flex-direction: column; height: 100vh">
    <a-layout-header class="header">
      <div class="logo" />
      <a-menu
        v-model:selectedKeys="topMenuSelect"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
      >
      </a-menu>
    </a-layout-header>
    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          :items="asideMenuConfig"
          @click="menuItemClickHandle"
          v-model:selectedKeys="asideMenuSelect"
          v-model:openKeys="openKeys"
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
        />
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item v-for="bread in breadCrumbItem">{{ bread }}</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: 'calc(100vh -96px)' }"
        >
          <RouterView/>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<style scoped></style>
