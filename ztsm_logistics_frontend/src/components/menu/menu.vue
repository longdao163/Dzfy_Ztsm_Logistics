<template>
	<div id='menu'>
	<el-menu :default-active="$route.path" class="mar-l el-menu-vertical-demo el-col el-col-3" light router>
      
      <el-menu-item-group title="系统设置">
        <template v-for="(item,index) in manager_item" v-if="!item.hidden">
          <el-menu-item :index="item.path" ><i class="fa" :class="item.class"></i>{{item.title}}</el-menu-item>
        </template>
       </el-menu-item-group>

      <el-menu-item-group title="报销管理">

        <template v-for="(item,index) in plan_item" v-if="!item.hidden">
          <el-menu-item :index="item.path" ><i class="fa" :class="item.class"></i>{{item.title}}</el-menu-item>
        </template>

        <template v-for="(item,index) in reimbursement_item" v-if="!item.hidden">
          <el-menu-item :index="item.path" ><i class="fa" :class="item.class"></i>{{item.title}}</el-menu-item>
        </template>
      </el-menu-item-group>


	  <el-menu-item-group title="ElementUI介绍">
        <template v-for="(item,index) in element_item" v-if="!item.hidden">
          <el-menu-item :index="item.path" ><i class="fa" :class="item.class"></i>{{item.title}}</el-menu-item>
        </template>
	  </el-menu-item-group>
    </el-menu>
    </div>
</template>
<script>
  export default {
    data() {
      return {
        element_item: [
          {
            title: '表单',
            path: '/index/form',
            class: 'fa-newspaper-o'
          }, {
            title: '分页',
            path: '/index/epage',
            class: 'fa-pagelines'
          }, {
            title: '标签页',
            path: '/index/tab',
            class: 'fa-tag'
          }, {
            title: '导航栏',
            path: '/index/navmenu',
            class: 'fa-bars'
          }, {
            title: '步骤条',
            path: '/index/step',
            class: 'fa-step-forward'
          }
        ],
        manager_item: [
          {
            title: '驾驶员管理',
            path: '/index/driver',
            class: 'fa-user'
          }, {
            title: '车辆管理',
            path: '/index/car',
            class: 'fa-car'
          }
        ],

         plan_item: [
          {
            title: '待处理报销',
            path: '/index/expensing',
            class: 'fa-dollar'
          },
        ],

         reimbursement_item: [
          {
            title: '已完成报销',
            path: '/index/expensed',
            class: 'fa-newspaper-o'
          }
        ],
      }
    }
  }
</script>
<style>
  i.fa {
    vertical-align: baseline;
    margin-right: 10px;
  }
  #menu .el-menu {
    height: 100%;
    background-color: #fff;
    position: fixed;
    float: left;
    border-right: solid 1px #ccc;
    overflow: auto;
  }
</style>