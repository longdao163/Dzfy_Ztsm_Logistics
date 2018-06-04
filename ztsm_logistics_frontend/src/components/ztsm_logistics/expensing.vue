<template>
<div>
  <el-row :gutter="20">
    <el-col :span="35">
      <div class="demo-block">
        <el-tabs v-model="activeExpense" type="card">
          <el-tab-pane label="出车情况" name="first">
            <!-- 待处理主页面  -->

            <section>
              <el-row>
                <el-col :span="25"> 
                  <!--表单-->
                  <el-form :inline="true" :model="params" class="demo-form-inline">
                    <el-form-item label="报销单号">
                      <el-input v-model="params.bxdh" placeholder="报销单号"></el-input>
                    </el-form-item>
                    <el-form-item label="车牌号码">
                      <el-input v-model="params.chhm" placeholder="车牌号码"></el-input>
                    </el-form-item>
                    <el-form-item label="司机">
                      <el-input v-model="params.sjxm" placeholder="司机"></el-input>
                    </el-form-item>
                    <el-button type="primary" icon="search" @click="searchCarPlan">查询</el-button>
                    <el-button type="primary" @click="reset">重置</el-button>
                    <!-- <el-button type="primary" icon="delete" @click="deleteAll">批量删除</el-button> -->
                    <el-button type="primary" icon="plus" @click="addCarPlan">新增出车</el-button>
                  </el-form>
                  
                  <!--表格-->
                  <el-table
                    :data="tableData"
                    border
                    style="width: 100%">
                    </el-table-column>

                   <!-- <el-table-column type="selection"/> -->

                    <el-table-column
                      prop="jhbs"
                      label="计划标识"
                      sortable
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="bxdh"
                      label="报销单号"
                      sortable
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="ccsj"
                      label="出车时间"
                      :formatter="dateFormat"
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="chhm"
                      label="车牌号码"
                      sortable
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="sjxm"
                      label="司机"
                      width="100">
                    </el-table-column>
                    <el-table-column
                      prop="fhdd"
                      label="发货地点"
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="fhdw"
                      label="发货单位"
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="fhr"
                      label="发货人"
                      width="100">
                    </el-table-column>
                    <el-table-column
                      prop="fhdh"
                      label="发货电话"
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="shdd"
                      label="收货地点"
                      width="120">
                    </el-table-column>
                    <el-table-column
                      prop="shdw"
                      label="收货单位"
                      width="120">
                    </el-table-column> 
                    <el-table-column
                      prop="shr"
                      label="收货人"
                      width="100">
                    </el-table-column> 
                    <el-table-column
                      prop="shdh"
                      label="收货电话"
                      width="120">
                    </el-table-column>                                     
                    <el-table-column
                      prop="cczt"
                      label="出车状态"
                      sortable
                      :formatter="typeFormat"
                      width="120">
                    </el-table-column>

                    <el-table-column label="操作">
                      <template scope="scope">
                        <el-button type="primary" size="small" @click="searchCarGoods(scope.$index, scope.row)">查看</el-button>
                        <el-button type="primary" size="small" @click="auditCarPlan(scope.$index, scope.row)">审核</el-button>
                        <el-button type="danger" size="small" @click="deleteCarPlan(scope.$index, scope.row)">删除</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                  <div class="block">
                    <el-pagination
                      @size-change="sizeChange"
                      @current-change="currentChange"
                      :current-page="params.pageNum"
                      :page-sizes="[10, 30, 50, 100]"
                      :page-size="params.pageSize"
                      layout="total, sizes, prev, pager, next, jumper"
                      :total="total">
                    </el-pagination>
                  </div>
                </el-col>
              </el-row>

            </section>
          </el-tab-pane>
          <!-- 待处理主页面完  -->


          <!-- 出车安排主页面  -->
          <el-tab-pane label="出车安排" name="second">
            

      <!-- 待编辑出车安排界面
           上文字，下列表
       -->

            <user-form 
                  ref="driverForm" 
                  v-on:close="cancelCarPlan">  
                </user-form>
                <el-form ref="driverForm" :model="driverForm" label-width="80px">

                  <div>
                    <el-row :gutter="20">
                      <el-col :span="20">
                        <div class="demo-block">
                          <el-tabs v-model="activePlan" @tab-click="handleClick">
                            <el-tab-pane label="基本信息" name="first">
                               
                            <!-- 计划基本信息主页面  -->  
                           
                            <el-form-item label="车辆标识">
                              <el-input v-model="driverForm.xtbs"></el-input>
                            </el-form-item>
                            <el-form-item label="车牌号码">
                              <el-input v-model="driverForm.cphm"></el-input>
                            </el-form-item>

                            <!-- 计划基本信息主页面完  -->
                            </el-tab-pane>
                            <el-tab-pane label="货品收发" name="second">
                            <!-- 货品收发主页面  -->  
                           

                            <!-- 货品收发主页面完  -->
                            </el-tab-pane>
                          </el-tabs>
                        </div>
                      </el-col>
                    </el-row>
                  </div> 

                <el-form-item>
                    <el-button @click="saveCarPlan">保存</el-button>
                    <el-button @click="cancelCarPlan">取消</el-button>
                </el-form-item> 

                </el-form>                         

           <!-- 出车安排主页面完  -->

          </el-tab-pane>

          <!-- 报销审核主页面  --> 
          <el-tab-pane label="报销审核" name="thrid">
            
            
                           



          </el-tab-pane>
           <!-- 报销审核主页面完  -->
        </el-tabs>
      </div>
    </el-col>
  </el-row>
</div>
</template>

<script>
export default {
  data () {
    return {
      activeExpense: 'first',
      activePlan: 'first',
      params: {
        cphm: '',
        pageNum: 1,
        pageSize: 10
      },
      tableData: [],
      dialogFormVisible: false,
      editLoading: false,
      driverForm: {
        xtbs: '',
        cphm: '',
        cllx: 1,
        clpp: '',
        clxh: '',
        clys: '',
        hzdw: 0,
        gmsj: '',
        fpbh: '',
      },
      total: 0,
      table_index: 999,
    };
  },
  created () {
    // var p = JSON.parse(JSON.stringify(this.params));
    // this.$http.post('/user/getAllUser.do', p).then((response) => {
    //   var pageUser = response.data;
    //   this.total = pageUser.total;
    //   this.params.pageNum = pageUser.pageNum;
    //   this.tableData = pageUser.list;
    // });
    this.searchCarPlan ();
  },
  methods: {
    dateFormat (row, column) {
      var date = row['gmsj'];
      if (date === undefined) {
        return "";
      }
      return this.$dateFormat(date);
    },


    typeFormat(row, column) {
      var type = row['cczt'];
      if (type === undefined) {
        return "";
      }

      switch(type){
        case 1:
          return "已发布";
        case 2:
          return "出车中";
        case 3:
          return "报销中";          
        default:
          return "已报销";
      }

    },

    //
    // 查询车辆
    // 
    searchCarPlan () {
      var p = JSON.parse(JSON.stringify(this.params));
      this.$http.post('/car/getCars.do', p).then((response) => {
        var pageUser = response.data;
        this.total = pageUser.total;
        this.params.pageNum = pageUser.pageNum;

        // for (var i = 0; i < pageUser.list.length; i++)
        // {
        //     // 显示司机性别
        //     // if(pageUser.list[i].xb)
        //     // {
        //     //     pageUser.list[i].xb = "男"  ;
        //     // }else{
        //     //     pageUser.list[i].xb = "女"
        //     // }

        //     // 显示日期
        //     // var driverBrithday = new Date(pageUser.list[i].csny);
        //     // var driverYear = driverBrithday.getFullYear();
        //     // var driverMonth = driverBrithday.getMonth()+1;
        //     // var driverDay = driverBrithday.getDate();
        //     // pageUser.list[i].csny = [driverYear,driverMonth,driverDay].join('-');
        // }

        this.tableData = pageUser.list;
      });
    },
    reset () {
      this.params.bxdh = '';
      this.searchCarPlan();
    },
    // deleteAll () {
    //   this.$message.error('还没做呢!');
    // },

    // 删除驾驶员
    deleteCarPlan (index, row) {

          this.$http.post('/car/removeCar.do', row['xtbs']).then((response) => {
          // 判断新增数据是否成功
          var isRemovedOk = response.data;
          if(isRemovedOk){
                this.$message({
                 message: "删除成功！",
                 type: 'success'
                 });
                this.tableData.splice(index, 1);
                }else{
                  this.$message.error('删除失败!'); 
                }
           });
    },

    auditCarPlan (index, row) {
      var rowTmp =  [].concat(JSON.parse(JSON.stringify(row)));


      switch(rowTmp[0]['cllx']){
        case 1:
          rowTmp[0]['cllx'] = "小型货车";
          break;
        case 2:
          rowTmp[0]['cllx'] = "中型货车";
          break;
        default:
          rowTmp[0]['cllx'] = "大型货车";
          break;
      }


      this.driverForm = Object.assign({}, rowTmp[0]);
      this.dialogFormVisible = true;
      this.table_index = index;
    },

    // 新增驾驶员
    addCarPlan () {      
      
      this.activeExpense = "second"
    },
    // 取消驾驶员编辑对话框
    cancelCarPlan(){
      this.dialogFormVisible = false;    //隐藏el-dialog
    },

    saveCar(){

                  var rowTmp =  [].concat(JSON.parse(JSON.stringify(this.driverForm)));

                  // 格式转换
                  switch(rowTmp[0].cllx){
                    case '1':
                      rowTmp[0].cllx = 1;
                      break;
                    case '2':
                      rowTmp[0].cllx = 2;
                      break;
                    default:
                      rowTmp[0].cllx = 3;
                      break;
                  }
                  // 购买时间还原为时间戳
                  rowTmp[0].gmsj = Date.parse(new Date(rowTmp[0].gmsj)); 
                  var p = JSON.parse(JSON.stringify(rowTmp[0]));

                  this.$http.post('/car/addCar.do', p).then((response) => {
                    // 判断新增数据是否成功
                      var isAddedOk = response.data;
                      if(isAddedOk){
                          this.$message({
                          message: "添加成功！",
                          type: 'success'
                          });
                          this.dialogFormVisible = false;
                          this.searchCarPlan();
                      }else{
                        this.$message.error('添加失败!'); 
                      }
                  });
                }

    },

    // download: function() {
    //   var obj = document.getElementById('download');
    //   var str = "账户名,昵称,真实车牌号码,出生日期,电话号码,微信号,qq号,邮箱,省份,城市\n";
    //   for (var i = 0; i < this.tableData.length; i++) {
    //     var item = this.tableData[i];
    //     str += item.userName + ',' + item.userNickname + ',' + item.userTruename + ',' + item.birthday + ',';
    //     str += item.telphone + ',' + item.wechat + ',' + item.qq + ',';
    //     str += item.email + ',' + item.province + ',' + item.city;
    //     str += "\n";
    //   }
    //   str = encodeURIComponent(str);
    //   obj.href = "data:text/csv;charset=utf-8,\ufeff" + str;
    //   obj.download = "users.csv";
    // },
    sizeChange(val) {
      this.params.pageSize = val;
      this.searchCarPlan();
    },
    currentChange(val) {
      this.params.pageNum = val;
      this.searchCarPlan();
    },
}

</script>
<style>
  .el-pagination {
    text-align: center;
    margin-top: 30px;
  }
  .el-message-box__btns .cancel {
    float: right;
    margin-left: 10px;
  }
</style>