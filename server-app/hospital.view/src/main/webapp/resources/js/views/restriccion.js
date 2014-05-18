var restriccion = {
	'formatForm' : function(regla) {
		generic.get("restriccion/paginas", null, function(paginas) {
			var treeRellenados = [];
			var treeSugeridos = [];
			var i;

			i = 0;
			paginas.forEach(function(pagina) {
				treeRellenados.push({
					title : pagina.nombre,
					folder : true,
					children : []
				});
				pagina.camposDTO.forEach(function(campoDTO) {
					var node = {
						title : campoDTO.nombre,
						key : campoDTO.id
					};
					if (regla != null) {
						regla.camposRellenadosDTO.forEach(function(campoRellenado) {
							if (node.key == campoRellenado.idCampo) {
								node.id = campoRellenado.id;
								node.selected = true;
							}
						});
					}
					treeRellenados[i].children.push(node);
				});
				i++;
			});

			i = 0;
			paginas.forEach(function(pagina) {
				treeSugeridos.push({
					title : pagina.nombre,
					folder : true,
					children : []
				});
				pagina.camposDTO.forEach(function(campoDTO) {
					var node = {
						title : campoDTO.nombre,
						key : campoDTO.id
					};
					if (regla != null) {
						regla.camposSugeridosDTO.forEach(function(campoSugerido) {
							if (node.key == campoSugerido.idCampo) {
								node.id = campoSugerido.id;
								node.selected = true;
							}
						});
					}
					treeSugeridos[i].children.push(node);
				});
				i++;
			});

			$("#treeRellenados").fancytree({
				source : treeRellenados,
				icons : false,
				checkbox : true,
				selectMode : 3
			});
			$("#treeSugeridos").fancytree({
				source : treeSugeridos,
				icons : false,
				checkbox : true,
				selectMode : 3
			});
		});
	},
	'getParams' : function() {
		var id = $("#id").val();
		var titulo = $("#titulo").val();
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
			titulo : titulo,
			mensaje : mensaje
		};
		var entity = (id != null) ? 'restriccion/' + id : 'restriccion';
		generic.post(entity, data, function() {
			generic.getList('restriccion');
		});
	}
};