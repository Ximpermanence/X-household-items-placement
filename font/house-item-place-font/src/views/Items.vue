<template>
  <div class="container">
    <Navbar />
    <div class="content">
      <div class="operation-bar">
        <el-button type="primary" @click="showDialog">新增物品</el-button>
        <el-button type="danger" @click="batchDelete">批量删除</el-button>
      </div>

      <el-table
          :data="items"
          @selection-change="handleSelectionChange"
          style="width: 100%">
        <el-table-column type="selection"></el-table-column>
        <el-table-column prop="name" label="物品名称"></el-table-column>
        <el-table-column prop="description" label="描述"></el-table-column>
        <el-table-column label="操作" width="200">
          <template slot-scope="scope">
            <el-button size="mini" @click="editItem(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="deleteItem(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog :title="dialogTitle" :visible.sync="dialogVisible">
        <!-- 物品表单 -->
      </el-dialog>
    </div>
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue'

export default {
  components: { Navbar },
  data() {
    return {
      items: [],
      selectedItems: [],
      dialogVisible: false,
      dialogTitle: '新增物品'
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    handleSelectionChange(val) {
      this.selectedItems = val
    },
    batchDelete() {
      // 批量删除逻辑
    },
    editItem(item) {
      // 编辑逻辑
    },
    deleteItem(item) {
      this.$confirm('确认删除该物品吗？', '提示', {
        type: 'warning'
      }).then(async () => {
        // 调用删除接口
      })
    }
  },
  async created() {
    // 初始化加载数据
    // this.items = await getItems()
  }
}
</script>