var faq = {
	'rowID' : null,
	'formatList' : function() {
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Mensaje", "Descripcion"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'mensaje',
						index : 'mensaje',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'descripcion',
						index : 'descripcion',
						width : 60,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}
			],
			rowNum : 6,
			rowList : [
					3, 6
			],
			pager : '#paginadorLista',
			sortname : 'mensaje',
			sortorder : 'asc',
			ondblClickRow : function(rowid) {
				generic.getForm('faq', rowid);
			},
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnEditar").button("enable");
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
	},
	'formatForm' : function(operacion) {
		$("#btnCancel").button().click(function() {
			generic.getList('faq');
		});

		$("#btnSaveRegla").button().click(function() {
			faq.getParams();
		});

		if(operacion == 'new'){
			generic.get("faq/paginas", null, function(paginas) {
				var tree = [];
				var i = 0;
				paginas.forEach(function(pagina) {
					tree.push({
						title : pagina.nombre,
						folder : true,
						children : []
					});
					pagina.camposDTO.forEach(function(campoDTO) {
						tree[i].children.push({
							title : campoDTO.nombre,
							key : campoDTO.id
						});
					});
					i++;
				});

				$("#treeRellenados").fancytree({
					source : tree,
					icons : false,
					checkbox : true,
					selectMode : 3
				});
				$("#treeSugeridos").fancytree({
					source : tree,
					icons : false,
					checkbox : true,
					selectMode : 3
				});
			});
		}else if(operacion == 'edit'){
			generic.get("faq/paginas", null, function(paginas) {
				var tree = [];
				var i = 0;
				paginas.forEach(function(pagina) {
					tree.push({
						title : pagina.nombre,
						folder : true,
						children : []
					});
					pagina.camposDTO.forEach(function(campoDTO) {
						tree[i].children.push({
							title : campoDTO.nombre,
							key : campoDTO.id
						});
					});
					i++;
				});

				$("#treeRellenados").fancytree({
					source : tree,
					icons : false,
					checkbox : true,
					selectMode : 3
				});
				$("#treeSugeridos").fancytree({
					source : tree,
					icons : false,
					checkbox : true,
					selectMode : 3
				});
				generic.get("faq/", $("#id").val(), function(arguments) {
					var regla = arguments[0];
					var treeRellenados = $("#treeRellenados").fancytree('getTree');
					regla.camposRellenadosDTO.forEach(function(campoRellenado){
						treeRellenados.options.source.forEach(function(pagina){
							pagina.children.forEach(function(campo){
								if(campo.key == campoRellenado.idCampo){
									campo.id = campoRellenado.id;
									campo.selected = true;
								}
							});
						});
					});
					treeRellenados.reload();
					var treeSugeridos = $("#treeSugeridos").fancytree('getTree');
					regla.camposSugeridosDTO.forEach(function(campoSugerido){
						treeSugeridos.options.source.forEach(function(pagina){
							pagina.children.forEach(function(campo){
								if(campo.key == campoSugerido.idCampo){
									campo.id = campoSugerido.id;
									campo.selected = true;
								}
							});
						});
					});
					treeSugeridos.reload();
				});
			});
		}
	},
	'getParams' : function() {
		var id = $("#id").val();
		var descripcion = $("#descripcion").val();
		var mensaje = $("#mensaje").val();
		var camposSugeridos = [];
		var camposRellenados = [];
		var nodesRellenados = $("#treeRellenados").fancytree('getTree').getSelectedNodes();
		nodesRellenados.forEach(function(nodeRellenado) {
			if (!nodeRellenado.hasChildren()) {
				camposRellenados.push({
					idCampo : nodeRellenado.key,
					id : nodeRellenado.data.id
				});
			}
		});
		var nodesSugeridos = $("#treeSugeridos").fancytree('getTree').getSelectedNodes();
		nodesSugeridos.forEach(function(nodeSugerido) {
			if (!nodeSugerido.hasChildren()) {
				camposSugeridos.push({
					idCampo : nodeSugerido.key,
					id : nodeSugerido.data.id
				});
			}
		});
		var data = {
			id : id,
			camposSugeridosDTO : camposSugeridos,
			camposRellenadosDTO : camposRellenados,
			descripcion : descripcion,
			mensaje : mensaje
		};
		var entity = (id != null) ? 'faq/' + id : 'faq';
		generic.post(entity, data, function() {
			generic.getList('faq');
		});
	}
};