<template>
  <el-menu
      :default-active="$route.path"
      class="el-menu-vertical-demo"
      router
      style="height: 100vh; width: 200px">
    <el-menu-item index="/home">
      <i class="el-icon-s-home"></i>
      <span>主页</span>
    </el-menu-item>
    <el-menu-item index="/items">
      <i class="el-icon-box"></i>
      <span>物品管理</span>
    </el-menu-item>
    <el-menu-item index="/rooms">
      <i class="el-icon-office-building"></i>
      <span>房间管理</span>
    </el-menu-item>
  </el-menu>
</template>