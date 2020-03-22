$.ajax({
	url: "printGenreYearChart",
	success: function(result){
		var genresArr=JSON.parse(result).genres;
		var percentage1=JSON.parse(result).percentage1;
		var percentage2=JSON.parse(result).percentage2;
		var percentage3 = JSON.parse(result).percentage3;
		var percentage4 = JSON.parse(result).percentage4;
		drawlinechart(genresArr,percentage1,percentage2,percentage3,percentage4);
	}
})

function drawlinechart(genresArr,percentage1,percentage2,percentage3,percentage4){
	// Create the chart
	Highcharts.chart('container', {

	    title: {
	        text: 'Genre Trends Over the Years'
	    },


	    yAxis: {
	        title: {
	            text: 'Overall Movie percentage'
	        }
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 1990
	        }
	    },

	    series: [{
	        name: genresArr[0],
	        data: percentage1
	    }, {
	        name: genresArr[1],
	        data: percentage2
	    }, {
	        name: genresArr[2],
	        data: percentage3
	    }, {
	        name: genresArr[3],
	        data: percentage4
	    }],

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }

	});
}


