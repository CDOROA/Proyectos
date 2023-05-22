function InicioCatalogo()
{
	AjustarTamanioCatalgo();
	
	if(window.addEventListener) {
		// navegadores que utilizan los estandares
		window.addEventListener("resize",AjustarTamanioCatalgo);
		window.addEventListener("scroll",AjustarTamanioCatalgo);
	}else{
		// Los navegadores de Microsoft... siempre ayudando a los desarrolladores...
		window.attachEvent("onresize",AjustarTamanioCatalgo);
		window.attachEvent("onscroll",AjustarTamanioCatalgo);
	}

}
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
function AjustarTamanioCatalgo()
{
	var catalogo  = getParameterByName('catalogo');
	var screenWidth = screen.width;
	var screenHeight = screen.height;

	// Get the browser window size
	var windowWidth = window.innerWidth;
	var windowHeight = window.innerHeight;

	// Get the size of the entire webpage
	const pageWidth  = document.documentElement.scrollWidth;
	const pageHeight = document.documentElement.scrollHeight;
	
	 var tHeader = document.getElementById("CHeader").offsetHeight;
     var tFooter = document.getElementById("CFooter").offsetHeight; 
	
     var tamanioCatalogo = pageHeight - ( tHeader + tFooter+77);
     
/*	alert("Device Screen: width: " + screenWidth + ", height: " + screenHeight + ".\n"+
          "Browser Window: width: " + windowWidth + ", height: " + windowHeight + ".\n"+
          "Webpage: width:" + pageWidth + ", height: " + pageHeight +  ".\n"+
          "HEDAR  height: " + tHeader +  ".\n"+
          "FOOTER height: " + tFooter +  ".\n"+
          "tamañoCatalogo: " + tamanioCatalogo+"." );
	*/
     
//    var catalogoAjsutado = ' <a href="https://catalogomaster.oep.com.mx/view/521867881/" class="fbo-embed" data-fbo-id="521867881" data-fbo-ratio="16:9" data-fbo-lightbox="yes" data-fbo-width="100%" data-fbo-height="'+ tamanioCatalogo +'px" data-fbo-version="1" style="max-width: 100%">CATÁLOGO MÁSTER 2022 OEP MAYORISTA</a><script async defer src="https://online.flippingbook.com/EmbedScriptUrl.aspx?m=redir&hid=521867881"></script>'
     $("menuCatalogos").hide() 
     $("contendedorCatalogo").hide()
     switch (catalogo) 
     {
		case 'master':
			catalogoAjsutado = 
				'<a href="https://catalogomaster.oep.com.mx/view/168792600/" class="fbo-embed" data-fbo-id="82910e4d00" data-fbo-ratio="3:2" data-fbo-lightbox="yes" data-fbo-width="100%" data-fbo-height="'+ tamanioCatalogo +'px" data-fbo-version="1" style="max-width: 100%">CATALOGO MÁSTER 2022 OEP </a><script async defer src="https://online.flippingbook.com/EmbedScriptUrl.aspx?m=redir&hid=168792600"></script>'
				$("#contendedorCatalogo").html(catalogoAjsutado);
			$("contendedorCatalogo").show()
			break;
		case 'embrague':
			catalogoAjsutado = 
				'<a href="https://catalogokitembrague.oep.com.mx/view/1030661411/" class="fbo-embed" data-fbo-id="95ac61d021" data-fbo-ratio="3:2" data-fbo-lightbox="yes" data-fbo-width="100%" data-fbo-height="'+ tamanioCatalogo +'px" data-fbo-version="1" style="max-width: 100%">CATÁLOGO KIT DE EMBRAGUE </a><script async defer src="https://online.flippingbook.com/EmbedScriptUrl.aspx?m=redir&hid=1030661411"></script>'
				$("#contendedorCatalogo").html(catalogoAjsutado);
			$("contendedorCatalogo").show()
			break;
		case 'diptico':
			catalogoAjsutado = 
				'<a href="https://diptico.oep.com.mx/view/219697054/" class="fbo-embed" data-fbo-id="8a0c764541" data-fbo-ratio="3:2" data-fbo-lightbox="yes" data-fbo-width="100%" data-fbo-height="'+ tamanioCatalogo +'px" data-fbo-version="1" style="max-width: 100%">Díptico digital </a><script async defer src="https://online.flippingbook.com/EmbedScriptUrl.aspx?m=redir&hid=219697054"></script>'
				$("#contendedorCatalogo").html(catalogoAjsutado);
			$("contendedorCatalogo").show()
			break;
		default: 
			$("menuCatalogos").show() 
			break;
	}
	
	} 