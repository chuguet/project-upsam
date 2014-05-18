var sugerencia = {
	'formatForm' : function(regla) {
		$("#form-operacion").hide();

		$("#valor").keyup(function() {
			$("#tree").fancytree('getTree').getSelectedNodes()[0].data.valor = $(this).val();
			// var title =
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title;
			// if ($(this).val() != null && $(this).val() != "" &&
			// title.indexOf("Rellenado") == -1) {
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title =
			// title + " Rellenado";
			// }
			// else if (title.indexOf("Rellenado") != -1) {
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title.replace("Rellenado",
			// "");
			// }
			// $("#tree").fancytree('getTree').reload();
		});
		$("#operacion").change(function() {
			$("#tree").fancytree('getTree').getSelectedNodes()[0].data.operacion = $("#operacion :selected").val();
			// var title =
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title;
			// if ($("#operacion :selected").val() != -1 &&
			// title.indexOf("Rellenado") == -1) {
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title =
			// title + " Rellenado";
			// }
			// else if (title.indexOf("Rellenado") != -1) {
			// $("#tree").fancytree('getTree').getSelectedNodes()[0].title.replace("Rellenado",
			// "");
			// }
			// $("#tree").fancytree('getTree').reload();
		});

		generic.get("sugerencia/paginas", null, function(paginas) {
			var tree = [];
			var i;

			i = 0;
			paginas.forEach(function(pagina) {
				tree.push({
					title : pagina.nombre,
					folder : true,
					children : []
				});
				pagina.camposDTO.forEach(function(campoDTO) {
					var node = {
						title : campoDTO.nombre + " [" + campoDTO.minValue + ", " + campoDTO.maxValue + "]",
						key : campoDTO.id,
					};
					if (regla != null) {
						regla.camposInfosDTO.forEach(function(campoInfo) {
							if (node.key == campoInfo.idCampo) {
								node.id = campoInfo.id;
								node.operacion = campoInfo.operacion;
								node.valor = campoInfo.valor;
							}
						});
					}
					tree[i].children.push(node);
				});
				i++;
			});

			$("#tree").fancytree({
				source : tree,
				icons : false,
				checkbox : true,
				selectMode : 1,
				select : function(flag, node) {
					if (!node.node.isSelected() || node.node.hasChildren()) {
						$("#form-operacion").hide();
					}
					else {
						$("#form-operacion").show();
						if (node.node.data.operacion != null && node.node.data.valor != null) {
							$("#valor").val(node.node.data.valor);
							var byDefault = node.node.data.operacion;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
						else {
							$("#valor").val(null);
							var byDefault = -1;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
					}
				}
			});
		});
	},
	'getParams' : function() {
		var id = $("#id").val();
		var titulo = $("#titulo").val();
		var mensaje = $("#mensaje").val();
		var camposInfo = [];
		var nodesInfo = $("#tree").fancytree('getTree');
		nodesInfo.rootNode.children.forEach(function(nodeParent) {
			nodeParent.children.forEach(function(node) {
				if (node.data.operacion != null && node.data.valor != null) {
					camposInfo.push({
						idCampo : node.key,
						operacion : node.data.operacion,
						valor : node.data.valor,
						id : node.data.id
					});
				}
			});
		});
		var data = {
			id : id,
			tipoRegla : 1,
			camposInfosDTO : camposInfo,
			titulo : titulo,
			mensaje : mensaje
		};
		var entity = (id != null) ? 'sugerencia/' + id : 'sugerencia';
		generic.post(entity, data, function() {
			generic.getList('sugerencia');
		});
	}
};