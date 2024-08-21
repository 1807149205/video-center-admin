<script lang="ts" setup>
import {onMounted, reactive, ref} from 'vue';
import HTTPClient from "@/utils/HTTPClient";

const columns = [
  {
    title: '名称视频',
    dataIndex: 'videoName',
    key: 'videoName',
  },
  {
    title: '视频时间',
    dataIndex: 'videoTime',
    key: 'videoTime',
  },
  {
    title: '视频状态',
    dataIndex: 'videoStatus',
    key: 'videoStatus',
  },
      {
        title: '视频创建时间',
        dataIndex: 'videoCreateDate',
        key: 'videoCreateDate'
      },
      {
        title: '视频更新时间',
        dataIndex: 'videoUpdateDate',
        key: 'videoUpdateDate'
      }
]

const pageConfig = reactive({
  pageSize: 5,
  current: 1,
  total: 0
})
const tableData = ref([]);
const searchBtnLoading = ref(false);
const tableLoading = ref(false);
const searchForm = reactive({
    videoName: '',
    videoStatus: '1'
})

const fetchTableData = async () => {
  tableLoading.value = true;
  const resp = await HTTPClient.post(`/video/getVideoPage/${pageConfig.current}/${pageConfig.pageSize}`)
  const {records} = resp.data;
  console.log(records)
  tableLoading.value = false;
}

const initPage = async () => {
  await fetchTableData();
}

onMounted(async () => {
  await initPage();
})

</script>

<template>
<div class="videoSearchContainer">
    <a-space :size="20">
        <a-space>
            <span>视频名称：</span>
            <a-input v-model:value="searchForm.videoName" placeholder="视频名称，支持模糊搜索" />
        </a-space>
        <a-space>
            <span>视频状态：</span>
            <a-select
                ref="select"
                v-model:value="searchForm.videoStatus"
                style="width: 120px"
                >
                <a-select-option value="1">正常</a-select-option>
                <a-select-option value="2">已删除</a-select-option>
                <a-select-option value="3">审核中</a-select-option>
            </a-select>
        </a-space>
      <a-space>
        <a-button :loading="searchBtnLoading" type="primary" style="width: 100px">搜索</a-button>
      </a-space>
    </a-space>
</div>
<a-divider />
<div class="videoTableContainer">
  <a-table :pagination="pageConfig" :loading="tableLoading" :data-source="tableData" :columns="columns"/>
</div>
</template>

<style scoped>

</style>