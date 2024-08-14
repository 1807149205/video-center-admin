<script lang="ts" setup>
import { reactive } from 'vue';


const searchForm = reactive({
    videoName: '',
    videoStatus: '1'
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
    </a-space>
</div>
<a-divider />
<div class="videoTableContainer">

</div>
</template>

<style scoped>

</style>