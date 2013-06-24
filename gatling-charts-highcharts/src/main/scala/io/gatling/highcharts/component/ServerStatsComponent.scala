/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Gatling Highcharts License
 */
package io.gatling.highcharts.component

import io.gatling.core.result.{ IntVsTimePlot, PieSlice, Series }
import io.gatling.highcharts.series.{ ValueOverTimeSeries, StackedColumnSeries }
import io.gatling.highcharts.template.{ ServerStatsTemplate, GroupDetailsDurationDistributionTemplate }

object ServerStatsComponent {

	def apply(runStart: Long, runEnd: Long, cpuSeries: Seq[Series[IntVsTimePlot]]) = {

		val template = new ServerStatsTemplate(
			cpuSeries.map { s => new ValueOverTimeSeries(s.name, runStart, s.data, s.colors.head) })

		new HighchartsComponent(template)
	}
}