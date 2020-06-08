<div id="part-table-div" class="div-id">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Data-Tables</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">SystemDataTables</h6>

            <form>
                <label for="choice">选择数据类型：</label>
                <select id="choice" onchange="choiceDataType()">
                    <option value="-1">待选择</option>
                    <option value="0">0:日志数据</option>
                    <option value="1">1:库存数据</option>
                    <option value="2">2:类型代码</option>
                    <option value="3">3:供应商数据</option>
                    <option value="4">4:采购记录</option>
                    <option value="5">5:销售记录</option>
                    <option value="6">6:过期药品</option>
                    <option value="7">7:用户表</option>
                </select>
                <input type="hidden" value="-1" id="choice-val">
                <a id="excel-btn" class="btn btn-primary" style="display: none" href="#">导出Excel</a>
                <a id="flush-table" class="btn btn-primary" onclick="flushData()" href="">手动刷新该表</a>
                <div class="card bg-info text-white">
                    <div class="card-body">详细易看数据请导出</div>
                </div>
            </form>
        </div>
        <div class="card-body">
            <div class="table-responsive table-data-container">

            </div>
        </div>
    </div>

</div>
