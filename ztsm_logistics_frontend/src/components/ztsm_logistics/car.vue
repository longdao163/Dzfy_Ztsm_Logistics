<template>
  <section>
    <el-row>
      <el-col :span="25"> 
        <!--表单-->
        <el-form :inline="true" :model="params" class="demo-form-inline">
          <el-form-item label="车牌号码">
            <el-input v-model="params.cphm" placeholder="车牌号码"></el-input>
          </el-form-item>
          <el-button type="primary" icon="search" @click="searchCar">查询</el-button>
          <el-button type="primary" @click="reset">重置</el-button>
          <!-- <el-button type="primary" icon="delete" @click="deleteAll">批量删除</el-button> -->
          <el-button type="primary" icon="plus" @click="addCar">新增车辆</el-button>
<!--           <a href="javascript:;" id="download" style="float: right;color: #169bd5;font-size: 14px;padding-top: 7px" @click="download()" download="download.csv">导出数据</a> -->
        </el-form>
        
        <!--表格-->
        <el-table
          :data="tableData"
          border
          style="width: 100%">
          </el-table-column>

         <!-- <el-table-column type="selection"/> -->

          <el-table-column
            prop="xtbs"
            label="车辆标识"
            sortable
            width="120">
          </el-table-column>
          <el-table-column
            prop="cphm"
            label="车牌号码"
            sortable
            width="120">
          </el-table-column>
          <el-table-column
            prop="cllx"
            label="车辆类型"
            sortable
            :formatter="typeFormat"
            width="120">
          </el-table-column>
          <el-table-column
            prop="clpp"
            label="车辆品牌"
            sortable
            width="120">
          </el-table-column>
          <el-table-column
            prop="clxh"
            label="车辆型号"
            width="120">
          </el-table-column>
          <el-table-column
            prop="clys"
            label="车辆颜色"
            width="120">
          </el-table-column>
          <el-table-column
            prop="hzdw"
            label="核载吨位"
            width="120">
          </el-table-column>
          <el-table-column
            prop="gmsj"
            label="购买时间"
            :formatter="dateFormat"
            width="180">
          </el-table-column>
          <el-table-column
            prop="fpbh"
            label="发票编号"
            width="120">
          </el-table-column>
         
          <el-table-column label="操作">
            <template scope="scope">
              <el-button type="primary" size="small" @click="carEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="deleteCar(scope.$index, scope.row)">删除</el-button>
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

    <el-dialog title="新增编辑车辆" v-model="dialogFormVisible" size="tiny">
      <user-form 
        :dialog-type="dialogType"
        ref="driverForm" 
        v-on:close="cancelCar">  
      </user-form>

      <el-form ref="driverForm" :model="driverForm" label-width="80px">

        <el-form-item label="车辆标识">
          <el-input v-model="driverForm.xtbs"></el-input>
        </el-form-item>
        <el-form-item label="车牌号码">
          <el-input v-model="driverForm.cphm"></el-input>
        </el-form-item>

        <el-form-item label="车辆类型">
           <!--  <el-col :span="10"> -->
                  <el-select v-model= "driverForm.cllx" value-key=1>
                    <el-option label="小型货车" value=1 key=1></el-option>
                    <el-option label="中型货车" value=2 key=2></el-option>
                    <el-option label="大型货车" value=3 key=3></el-option>
                  </el-select>
            <!-- </el-col> -->
          </el-form-item>

<!--         <el-form-item label="性别">
          <el-col :span="10">
            <el-input v-model="driverForm.xb">
                    <el-select v-model="driverForm.xb">
                      <el-option label="男" value="0" key="0"></el-option>
                      <el-option label="女" value="1" key="1"></el-option>
                    </el-select>
            </el-input>
          </el-col>
        </el-form-item> -->

        <el-form-item label="车辆品牌">
          <el-input v-model="driverForm.clpp"></el-input>
        </el-form-item>   
        <el-form-item label="车辆型号">
          <el-input v-model="driverForm.clxh"></el-input>
        </el-form-item>
        <el-form-item label="车辆颜色">
          <el-input v-model="driverForm.clys"></el-input>
        </el-form-item>
        <el-form-item label="核载吨位">
          <el-input v-model="driverForm.hzdw"></el-input>
        </el-form-item> 
        <el-form-item label="购买时间">
          <el-date-picker type="date" placeholder="购买时间" v-model="driverForm.gmsj" style="width: 100%;" ></el-date-picker>
        </el-form-item>
        <el-form-item label="发票编号">
          <el-input v-model="driverForm.fpbh"></el-input>
        </el-form-item> 
        <el-form-item>
            <el-button @click="saveCar">保 存</el-button>
            <el-button @click="cancelCar">取 消</el-button>
        </el-form-item>       
      </el-form>
    </el-dialog>
  </section>
</template>

<script>
export default {
  data () {
    return {
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
      dialogType:'',
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
    this.searchCar ();
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
      var type = row['cllx'];
      if (type === undefined) {
        return "";
      }

      switch(type){
        case 1:
          return "小型货车";
        case 2:
          return "中型货车";
        default:
          return "大型货车";
      }

    },

    //
    // 查询车辆
    // 
    searchCar () {
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
      this.params.cphm = '';
      this.searchCar();
    },
    // deleteAll () {
    //   this.$message.error('还没做呢!');
    // },

    // 删除驾驶员
    deleteCar (index, row) {

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

    carEdit (index, row) {
      this.dialogType = 'edit'; 
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
    addCar () {
      this.dialogType = 'add';      
      this.driverForm = Object.assign({}, );
      this.dialogFormVisible = true;
      // this.form = Object.assign({}, row);
      // this.table_index = index;
    },
    // 取消驾驶员编辑对话框
    cancelCar(){
      this.dialogFormVisible = false;    //隐藏el-dialog
    },

    saveCar(){
          switch(this.dialogType){
             // 新增驾驶员
            case 'add':
                {
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
                          this.searchCar();
                      }else{
                        this.$message.error('添加失败!'); 
                      }
                  });
                }
             break;
            // 编辑驾驶员
            case 'edit':
                {
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

                  this.$http.post('/car/editCar.do', p).then((response) => {
                    // 判断更新数据是否成功
                      var isUpdatedOk = response.data;
                      if(isUpdatedOk){
                          this.$message({
                          message: "更新成功！",
                          type: 'success'
                          });
                          this.dialogFormVisible = false;
                          this.searchCar();
                      }else{
                        this.$message.error('更新失败!'); 
                      }
                  });
                } 
              break;
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
      this.searchCar();
    },
    currentChange(val) {
      this.params.pageNum = val;
      this.searchCar();
    },
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
