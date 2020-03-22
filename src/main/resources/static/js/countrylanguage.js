$.ajax({
	url: "printLineChartforCountryLanguage",
	success: function(result){
		var country=JSON.parse(result).country;
		var nooflang80s=JSON.parse(result).nooflang80s;
		var nooflang90s=JSON.parse(result).nooflang90s;
		var nooflang2000s=JSON.parse(result).nooflang2000s;
		console.log(country);
		drawbarChart(country,nooflang80s,nooflang90s,nooflang2000s);
	}
})

function drawbarChart(country,nooflang80s,nooflang90s,nooflang2000s){
	Highcharts.chart('container', {
		  chart: {
		    type: 'bar'
		  },
		  title: {
		    text: 'Top 5 diverse countries from 1980 to 2017'
		  },
		  xAxis: {
		    categories: [country[0], country[1], country[2], country[3],country[4]],
		    title: {
		      text: null
		    }
		  },
		  yAxis: {
		    min: 0,
		    title: {
		      text: 'Number of Languages',
		      align: 'high'
		    },
		    labels: {
		      overflow: 'justify'
		    }
		  },
		  tooltip: {
		    valueSuffix: ' Languages'
		  },
		  plotOptions: {
		    bar: {
		      dataLabels: {
		        enabled: true
		      }
		    }
		  },
		  legend: {
		    layout: 'vertical',
		    align: 'right',
		    verticalAlign: 'top',
		    x: -40,
		    y: 80,
		    floating: true,
		    borderWidth: 1,
		    backgroundColor:
		      Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
		    shadow: true
		  },
		  credits: {
		    enabled: false
		  },
		  series: [{
		    name: '1980-1990',
		    data: nooflang80s
		  }, {
		    name: '1990-2000',
		    data: nooflang90s
		  }, {
		    name: '2000-2017',
		    data: nooflang2000s
		  }]
		});
}


