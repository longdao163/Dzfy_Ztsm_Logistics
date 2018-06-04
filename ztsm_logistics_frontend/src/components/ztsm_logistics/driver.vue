<template>
  <section>
    <el-row>
      <el-col :span="24">
        <!--表单-->
        <el-form :inline="true" :model="params" class="demo-form-inline">
          <el-form-item label="姓名">
            <el-input v-model="params.xm" placeholder="姓名"></el-input>
          </el-form-item>
<!--           <el-form-item label="性别">
            <el-input v-model="params.userNickName" placeholder="男"></el-input>
          </el-form-item> -->
<!--           <el-form-item label="性别" prop="sex" >
            <el-col :span="10">
                  <el-select v-model="params.xb"   placeholder="男" value-key="value"  >
                    <el-option label="男" value="0" key="0"></el-option>
                    <el-option label="女" value="1" key="1"></el-option>
                  </el-select>
            </el-col>
          </el-form-item> -->
          <el-form-item label="手机号">
            <el-input v-model="params.sjhm" placeholder="手机号码"></el-input>
          </el-form-item>          
          <el-form-item label="身份证号">
            <el-input v-model="params.sfzh" placeholder="身份证号码"></el-input>
          </el-form-item>
          <el-form-item label="驾驶证号">
            <el-input v-model="params.jszh" placeholder="驾驶证号码"></el-input>
          </el-form-item>
          <el-button type="primary" icon="search" @click="searchDriver">查询</el-button>
          <el-button type="primary" @click="reset">重置</el-button>
          <!-- <el-button type="primary" icon="delete" @click="deleteAll">批量删除</el-button> -->
          <el-button type="primary" icon="plus" @click="addDriver">新增驾驶员</el-button>
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
            prop="gh"
            label="工号"
            sortable
            width="100">
          </el-table-column>
          <el-table-column
            prop="xm"
            label="姓名"
            sortable
            width="100">
          </el-table-column>
          <el-table-column
            prop="xb"
            label="性别"
            sortable
            :formatter="sexFormat"
            width="90">
          </el-table-column>
          <el-table-column
            prop="csny"
            label="出生年月"
            sortable
            :formatter="dateFormat"
            width="120">
          </el-table-column>
          <el-table-column
            prop="sfzh"
            label="身份证号"
            width="120">
          </el-table-column>
          <el-table-column
            prop="jszh"
            label="驾驶证号"
            width="120">
          </el-table-column>
          <el-table-column
            prop="sjhm"
            label="手机号码"
            width="120">
          </el-table-column>
          <el-table-column
            prop="jtzz"
            label="家庭住址"
            width="180">
          </el-table-column>
          <el-table-column
            prop="wxbs"
            label="微信标识"
            width="120">
          </el-table-column>
          <el-table-column
            prop="wxnc"
            label="微信昵称"
            width="120">
          </el-table-column>
          <el-table-column
            prop="wxtx"
            label="微信头像"
            width="100">
          </el-table-column>
          <el-table-column label="操作">
            <template scope="scope">
              <el-button type="primary" size="small" @click="userEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="deleteUser(scope.$index, scope.row)">删除</el-button>
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

    <el-dialog title="新增编辑驾驶员" v-model="dialogFormVisible" size="tiny">
      <user-form 
        :dialog-type="dialogType"
        ref="driverForm" 
        v-on:close="cancelDriver">  
      </user-form>

      <el-form ref="driverForm" :model="driverForm" label-width="80px">

        <el-form-item label="工号">
          <el-input v-model="driverForm.gh"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="driverForm.xm"></el-input>
        </el-form-item>

        <el-form-item label="性别">
           <!--  <el-col :span="10"> -->
                  <el-select v-model= "driverForm.xb" value-key="0">
                    <el-option label="男" value="1" key="1"></el-option>
                    <el-option label="女" value="0" key="0"></el-option>
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

        <el-form-item label="出生年月">
          <el-date-picker type="date" placeholder="出生年月" v-model="driverForm.csny" style="width: 100%;" ></el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="driverForm.sfzh"></el-input>
        </el-form-item>
        <el-form-item label="驾驶证号">
          <el-input v-model="driverForm.jszh"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
          <el-input v-model="driverForm.sjhm"></el-input>
        </el-form-item> 
         <el-form-item label="家庭住址">
          <el-input v-model="driverForm.jtzz"></el-input>
        </el-form-item>    
        <el-form-item>
            <el-button @click="saveDriver">保 存</el-button>
            <el-button @click="cancelDriver">取 消</el-button>
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
        xm: '',
        sfzh: '',
        jszh: '',
        sjhm: '',
        pageNum: 1,
        pageSize: 10
      },
      tableData: [],
      dialogFormVisible: false,
      editLoading: false,
      driverForm: {
        gh: '',
        xm: '',
        xb: true,
        csny: '',
        sfzh: '',
        jszh: '',
        sjhm: '',
        jtzz: '',
        wxbs: '',
        wxnc: '',
        wxtx: '',
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
    this.searchDriver ();
  },
  methods: {
    dateFormat (row, column) {
      var date = row['csny'];
      if (date === undefined) {
        return "";
      }
      return this.$dateFormat(date);
    },


    sexFormat(row, column) {
      var sex = row['xb'];
      if (sex === undefined) {
        return "";
      }

      if(sex)
      {
          return "男"  ;
      }
      return "女";
    },

    //
    // 查询司机
    // 
    searchDriver () {
      var p = JSON.parse(JSON.stringify(this.params));
      this.$http.post('/driver/getDrivers.do', p).then((response) => {
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
      this.params.xm = '';
      this.params.sjhm = '';
      this.params.sfzh = '';
      this.params.jszh = '';
      this.searchDriver();
    },
    // deleteAll () {
    //   this.$message.error('还没做呢!');
    // },

    // 删除驾驶员
    deleteUser (index, row) {

          this.$http.post('/driver/removeDriver.do', row['gh']).then((response) => {
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

    userEdit (index, row) {
      this.dialogType = 'edit'; 
      var rowTmp =  [].concat(JSON.parse(JSON.stringify(row)));

      if(rowTmp[0]['xb'])
      {
          rowTmp[0]['xb'] = "1";
      }else{
          rowTmp[0]['xb'] = "0";
      }
      this.driverForm = Object.assign({}, rowTmp[0]);
      this.dialogFormVisible = true;
      this.table_index = index;
    },

    // 新增驾驶员
    addDriver () {
      this.dialogType = 'add';      
      this.driverForm = Object.assign({}, );
      this.dialogFormVisible = true;
      // this.form = Object.assign({}, row);
      // this.table_index = index;
    },
    // 取消驾驶员编辑对话框
    cancelDriver(){
      this.dialogFormVisible = false;    //隐藏el-dialog
    },

    saveDriver(){
          switch(this.dialogType){
             // 新增驾驶员
            case 'add':
                {
                  var rowTmp =  [].concat(JSON.parse(JSON.stringify(this.driverForm)));

                  // 格式转换
                  // 性别还原为布尔值
                  rowTmp[0].xb = (rowTmp[0].xb=="1"?true:false);
                  // 日期还原为时间戳
                  rowTmp[0].csny = Date.parse(new Date(rowTmp[0].csny)); 
                  var p = JSON.parse(JSON.stringify(rowTmp[0]));

                  this.$http.post('/driver/addDriver.do', p).then((response) => {
                    // 判断新增数据是否成功
                      var isAddedOk = response.data;
                      if(isAddedOk){
                          this.$message({
                          message: "添加成功！",
                          type: 'success'
                          });
                          this.dialogFormVisible = false;
                          this.searchDriver();
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
                  // 性别还原为布尔值
                  rowTmp[0].xb = (rowTmp[0].xb=="1"?true:false);
                  // 日期还原为时间戳
                  rowTmp[0].csny = Date.parse(new Date(rowTmp[0].csny)); 
                  var p = JSON.parse(JSON.stringify(rowTmp[0]));

                  this.$http.post('/driver/editDriver.do', p).then((response) => {
                    // 判断更新数据是否成功
                      var isUpdatedOk = response.data;
                      if(isUpdatedOk){
                          this.$message({
                          message: "更新成功！",
                          type: 'success'
                          });
                          this.dialogFormVisible = false;
                          this.searchDriver();
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
    //   var str = "账户名,昵称,真实姓名,出生日期,电话号码,微信号,qq号,邮箱,省份,城市\n";
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
      this.searchDriver();
    },
    currentChange(val) {
      this.params.pageNum = val;
      this.searchDriver();
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
