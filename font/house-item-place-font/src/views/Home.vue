<template>
  <div class="container">
    <Navbar />
    <div class="content">
      <el-input
          v-model="searchKey"
          placeholder="请输入搜索内容"
          @keyup.enter.native="search"
          style="width: 300px; margin: 20px"
      ></el-input>

      <el-table :data="searchResults" style="width: 100%">
        <el-table-column prop="name" label="名称"></el-table-column>
        <el-table-column prop="type" label="类型"></el-table-column>
        <el-table-column prop="location" label="位置"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue'

export default {
  components: { Navbar },
  data() {
    return {
      searchKey: '',
      searchResults: []
    }
  },
  methods: {
    async search() {
      // 调用搜索接口
      // this.searchResults = await searchItems(this.searchKey)
    }
  }
}
</script>