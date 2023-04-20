function abrirVideo(url_video)
{
	
	var scrollLeft = $(window).scrollLeft();
	
	var scrollTop = $(window).scrollTop();
	
	$("#etiquetaVideo").html("");
	let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'?autoplay=1" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	//let contenido = '<video src="'+url_video+'" controls="true" style="width: 100%"></video>';

	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	
	$("#etiquetaVideo").html(contenido);
	$('#modalImagenes').modal('hide');
 
	$('#modalVideos').modal('toggle');
}


function cargar(imagen)
{
	var modal = document.getElementById('myModal');

	// var img = document.getElementById(imagen);
	//var modalImg = document.getElementById("vid");
	    modal.style.display = "block";
		modal.style.zIndex = 99999;
		
		//modalImg.src = imagen + "?autoplay=1";
	var span = document.getElementsByClassName("close")[0];
	span.onclick = function() {
	    modalImg.src = "";
		modal.style.display = "none";
		modal.style.zIndex = 1;
	}
};