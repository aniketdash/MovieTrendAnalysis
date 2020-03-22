$.ajax({
	url: "countryprintbardrilldownchart",
	success: function(result){
		var productionCompaniesArr=JSON.parse(result).productionCompaniesArr;
		var totalProfitArr=JSON.parse(result).totalProfitArr;
		var profitGenreArr=JSON.parse(result).profitGenreArr;
		drawdrilldownchart(productionCompaniesArr,totalProfitArr,profitGenreArr);
	}
})

function drawdrilldownchart(productionCompaniesArr,totalProfitArr,profitGenreArr){
	// Create the chart
	Highcharts.chart('container', {
		  chart: {
		    type: 'column'
		  },
		  title: {
		    text: 'Top 5 Countries Dominating Movie Revenue'
		  },
		 
		  xAxis: {
		    type: 'category'
		  },
		  yAxis: {
		    title: {
		      text: 'Total Percentage Market Share '
		    }

		  },
		  legend: {
		    enabled: false
		  },
		  plotOptions: {
		    series: {
		      borderWidth: 0,
		      dataLabels: {
		        enabled: true,
		        format: '{point.y}%'
		      }
		    }
		  },

		  tooltip: {
		    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
		    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b> <br/>'
		  },

		  series: [
		    {
		      name: "Countries",
		      colorByPoint: true,
		      data: [
		        {
		          name: productionCompaniesArr[0],
		          y: totalProfitArr[0],
		          drilldown: productionCompaniesArr[0]
		        },
		        {
		          name: productionCompaniesArr[1],
		          y: totalProfitArr[1],
		          drilldown: productionCompaniesArr[1]
		        },
		        {
		          name: productionCompaniesArr[2],
		          y: totalProfitArr[2],
		          drilldown: productionCompaniesArr[2]
		        },
		        {
		          name: productionCompaniesArr[3],
		          y: totalProfitArr[3],
		          drilldown: productionCompaniesArr[3]
		        },
		        {
		          name: productionCompaniesArr[4],
		          y: totalProfitArr[4],
		          drilldown: productionCompaniesArr[4]
		        }
		      ]
		    }
		  ],
		  drilldown: {
		    series: [
		      {
		        name: productionCompaniesArr[0],
		        id: productionCompaniesArr[0],
		        data: profitGenreArr[0]
		      },
		      {
		        name: productionCompaniesArr[1],
		        id: productionCompaniesArr[1],
		        data: profitGenreArr[1]
		      },
		      {
		        name: productionCompaniesArr[2],
		        id: productionCompaniesArr[2],
		        data: profitGenreArr[2]
		      },
		      {
		        name: productionCompaniesArr[3],
		        id: productionCompaniesArr[3],
		        data: profitGenreArr[3]
		      },
		      {
		        name: productionCompaniesArr[4],
		        id: productionCompaniesArr[4],
		        data: profitGenreArr[4]
		      }
		    ]
		  }
		});
}


