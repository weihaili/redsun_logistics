var method = '';
var listParam ='';
var saveParam='';
var _name='waybill';
$(function(){
	$('#grid').datagrid({    
	    url:_name+'_listByCondition'+listParam,   
	    columns:getColumns(),
	    singleSelect: true,
	    rownumbers: true,
	    pagePosition: 'both',
	    pagination: true ,
	    //tool bar
	    toolbar: [
	        {
			    text: 'add',
				iconCls: 'icon-add',
				handler: function(){
					method="add";
					$('#addDlg').dialog('open');
					$('#addForm').form('clear');
				}
			},'-',{
				text:'download',
				iconCls: 'icon-excel',
				handler:function(){
					var _formdata=$('#searchForm').serializeJSON();
					$.download(name+'_export'+listParam,_formdata);
				}
			},'-',{
				text:'import',
				iconCls: 'icon-save',
				handler:function(){
					$('#importDlg').dialog('open');
				}
			}
		]
	}); 

	// query list by condition
	$('#btn_search').bind('click', function() {
		var formData = $('#searchForm').serializeJSON();
		$('#grid').datagrid('load', formData);
	});

	// add 
	var h=200;
	if(typeof(height)!='undefined'){
		h=height;
	}
	var w=500;
	if(typeof(width)!='undefined'){
		w=width;
	}
	
	/** initialization editDlg*/
	$('#editDlg').dialog({
		title : 'edit',
		width : w,
		height : h,
		closed : true,
		modal : true
	});
	/** initialization addDlg*/
	$('#addDlg').dialog({
		title : 'add record',
		width : w,
		height : h,
		closed : true,
		modal : true
	});

	// add button
	$('#btnSave').bind('click', function() {
		//form check return true when all field return true,otherwise return false
		var isValid =$('#editForm').form('validate');
		if(isValid==false) return;
		var formData = $('#editForm').serializeJSON();
		$.ajax({
			url : name+'_' + method+saveParam,
			data : formData,
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				$.messager.alert('note', rtn.message, 'info', function() {
					// if add success ,we close dialog windown,then reflush
					// tabale data
					$('#editDlg').dialog('close');
					$('#grid').datagrid('reload');
				});

				$('#grid').datagrid('loadData', rtn);
			}
		});
	});

	// cancel button
	$('#btnCancel').bind('click', function() {
		$('#editDlg').dialog('close');
	});
	
	var importForm=document.getElementById('importForm');
	if(importForm){
		$('#importDlg').dialog({
			title:'import data',
			height:200,
			width:400,
			closed:true,
			modal:true,
			buttons:[
			  {
				  text:'import',
				  handler:function(){
					  $.ajax({
						  url:name+'_doImport',
						  type:'post',
						  data:new FormData($('#importForm')[0]),
						  dataType:'json',
						  processData:false,
						  contentType:false,
						  success:function(_data){
							  $.messager.alert('system prompt message',_data.message,'info',function(){
								  if(_data.success){
									  $('#importDlg').dialog('close');
									  $('#importForm').form('clear');
									  $('#grid').datagrid('reload');
								  }
							  });
						  }
					  });
				  }
			  } ,{
				  text:'close',
				  handler:function(){
					  $('#importDlg').dialog('close');
				  }
			  }      
			]
		});
	}

});

// operation del
function del(uuid) {
	$.messager.confirm('confirm', 'Are you sure you want to delete the record?', function(yes) {
		if (yes) {
			$.ajax({
				url : name+'_delete?id=' + uuid,
				dataType : 'json',
				type : 'post',
				success : function() {
					$('#grid').datagrid('reload');
				}
			});
		}
	});
};

// operation edit update department information
function edit(uuid) {
	// pop-up window
	$('#editDlg').dialog('open');

	// load data
	// first clear form data then load new data
	$('#editForm').form('clear');
	method = "update";

	$('#editForm').form('load', name+'_get?id=' + uuid); // 读取表单的URL

};

/**
 * initialization display gird table head (namely show database field)
 */
function getColumns(){
	return [[
	    {field:'sn',title:'waybill number',width:100,align:'center'},   
	    {field:'userid',title:'user id',width:60,align:'center'},   
	    {field:'toaddress',title:'shipping address',width:120,align:'center'},   
	    {field:'addressee',title:'receiver',width:60,align:'center'},   
	    {field:'tele',title:'telephone',width:60,align:'center'},   
	    {field:'info',title:'info',width:180,align:'center'},   
	    {field:'state',title:'info',width:50,align:'center'}, 
	    {field:'-',title:'operation',width:100,align:'center',
        	formatter: function(value,row,index){
	        	var oper= ' <a href="javascript:void(0)" onclick="edit('+row.uuid+');">update</a>';
	        	oper+= ' <a href="javascript:void(0)" onclick="del('+row.uuid+');">delete</a>';
				return oper;
			}
	    }
	]];
}