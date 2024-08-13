<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
const topMenuSelect = ref<string[]>(['2']);
const asideMenuSelect = ref<string[]>(['videoEdit']);
const openKeys = ref<string[]>(['videoSub']);
const breadCrumbItem = ref<string[]>([]);

const asideMenuConfig = [
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
]

const menuItemClickHandle = (option) => {
  let index = 0;
  breadCrumbItem.value = [];
  const path = option.keyPath;
  console.log(path,'path');
  
  const deep = () => {
      if (breadCrumbItem.value.length > path.length) {
        console.log('退出递归',breadCrumbItem.value, path);
        
        return ;
      }
      for (const item of asideMenuConfig) {
        if (item.key === path[index]) {
          breadCrumbItem.value[index++] = item.text;
          console.log(breadCrumbItem.value);
          deep();
        }
      }
  }

  deep();
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
          @click="menuItemClickHandle"
          v-model:selectedKeys="asideMenuSelect"
          v-model:openKeys="openKeys"
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <template v-for="config in asideMenuConfig">
            <template v-if="config.children && config.children.length !== 0">
              <a-sub-menu :key="config.key">
                <template #title>
                  {{ config.text }}
                </template>
                <a-menu-item 
                  v-for="item in config.children"
                  :key="item.key">
                  {{ item.text }}
                </a-menu-item>
              </a-sub-menu>
            </template>
          </template>
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                subnav 1
              </span>
            </template>
            <a-menu-item key="1">option1</a-menu-item>
            <a-menu-item key="2">option2</a-menu-item>
            <a-menu-item key="3">option3</a-menu-item>
            <a-menu-item key="4">option4</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                subnav 2
              </span>
            </template>
            <a-menu-item key="5">option5</a-menu-item>
            <a-menu-item key="6">option6</a-menu-item>
            <a-menu-item key="7">option7</a-menu-item>
            <a-menu-item key="8">option8</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
              <span>
                <notification-outlined />
                subnav 3
              </span>
            </template>
            <a-menu-item key="9">option9</a-menu-item>
            <a-menu-item key="10">option10</a-menu-item>
            <a-menu-item key="11">option11</a-menu-item>
            <a-menu-item key="12">option12</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item v-for="bread in breadCrumbItem">{{ bread }}</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: 'calc(100vh -96px)' }"
        >
          Content
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<style scoped></style>
