function abrirVideo(url_video)
{
	
	var scrollLeft = $(window).scrollLeft();
	
	var scrollTop = $(window).scrollTop();
	
	$("#etiquetaVideo").html("");
	let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'?autoplay=1" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe>';
	//let contenido = '<video src="'+url_video+'" controls="true" style="width: 100%"></video>';

	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	
	$("#etiquetaVideo").html(contenido);
	$('#modalImagenes').modal('hide');
 
	$('#modalVideos').modal('toggle');
}