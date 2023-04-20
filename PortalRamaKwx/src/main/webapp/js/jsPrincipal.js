/***** EVENTO CAROUSEL ******/
$(document).ready(function ()
{
		    $("#myCarousel").carousel({
		        interval: 5000 //set the initial interval
		    });

		    //handle Bootstrap carousel slide event
		    $("#myCarousel").on("slide.bs.carousel", function (e)
		    {
		        //get the next interval from the data- HTML attribute
		        var interval = parseInt($(e.relatedTarget).data("interval"));

		        //set the interval by first getting a reference to the widget
		        $("#myCarousel").data("bs.carousel").options.interval =  interval;
		    });
		});