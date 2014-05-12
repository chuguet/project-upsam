var faq = {
	'rowID' : null,
	'tree1' : [],
	'tree2' : [],
	'formatList' : function() {
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Nombre", "Apellidos", "Email", "faq", "Rol"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'nombre',
						index : 'nombre',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'apellidos',
						index : 'apellidos',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},  {
						name : 'email',
						index : 'email',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},{
						name : 'user',
						index : 'user',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'rol',
						index : 'rol',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'center'
					}
			],
			rowNum : 6,
			rowList : [
					3,6
			],
			pager : '#paginadorLista',
			sortname : 'nombre',
			sortorder : 'asc',
			ondblClickRow : function(rowid){generic.getForm('faq', rowid);},
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnEditar").button("enable");
				$("#btnEliminar").button("enable");
				faq.rowID = rowid;
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del formulario de faqs**********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('faq');
		});
		$("#btnEditar").button().click(function() {
			generic.getForm('faq', $('#lista').jqGrid('getRowData', faq.rowID).id);
		});
		$("#btnEditar").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('faq', $('#lista').jqGrid('getRowData', faq.rowID).id, function() {
				generic.getList('faq');
			});
		});
		$("#btnEliminar").button("disable");
	},
	'formatForm' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('faq');
		});

		$("#btnSaveRegla").button().click(function() {
			faq.getParams();
		});
		
		generic.get("faq/paginas", null, function(paginas){
			var tree = [];
			var i = 0;
			paginas.forEach(function(pagina){
				tree.push({title: pagina.nombre, folder: true, key: pagina.id, children: []});
				pagina.camposDTO.forEach(function(campoDTO){
					tree[i].children.push({title: campoDTO.nombre, key: campoDTO.id});
				});
				i++;
			});
			
			$("#tree1").fancytree({
				source: tree,
				icons: false,
				checkbox: true,
				selectMode: 3,
			    select: function(event, data) {
			      faq.tree1 = [];
			      data.tree.getSelectedNodes().forEach(function(node){
			    	  if(!node.hasChildren()){
			    		  faq.tree1.push(node.key);
			    	  }
			      });
			    }
			});
			$("#tree2").fancytree({
				source: tree,
				icons: false,
				checkbox: true,
				selectMode: 3,
			    select: function(event, data) {
			    	faq.tree2 = [];
				      data.tree.getSelectedNodes().forEach(function(node){
				    	  if(!node.hasChildren()){
				    		  faq.tree2.push(node.key);
				    	  }
				      });
			    }
			});
		});

	},
	'getParams' : function() {
		var id = $("#id").text();
		var descripcion = $("#descripcion").val();
		var data={tree1 : faq.tree1,
					tree2 : faq.tree2,
					descripcion : descripcion};
		var entity = (id != null) ? 'faq/' + id : 'faq';
		generic.post(entity, data, function() {
			generic.getList('faq');
		});
	}
};