$.ajax({
	url: "printLineChart",
	success: function(result){
		var genre=JSON.parse(result).genre;
		var movieCount=JSON.parse(result).movieCount;
		drawLineChart(genre,movieCount);
	}
})


function drawLineChart(genre,movieCount){
Highcharts.chart('container', {
	chart: {
        type: 'line'
    },
    
    title: {
	    text: 'Genres Preferred by Active Writers'
	  },
	  
    xAxis: {
    	title: {
            text: 'Genre'
        },
        categories: genre
        
    },
	    
	    yAxis: {
	    	title: {
                text: 'Movie Count'
            }
	        
	    },
	    
	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y;
	        }
	    },
	
	    series: [{
	        data: movieCount
	    }]
	});
}