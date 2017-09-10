import { Component, OnInit } from '@angular/core';
import { ChartDataProviderService, ChartResponse } from './chart';
//import { ChartResponse } from '../domain';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ChartApp';

  private chartData: ChartResponse;

  constructor(private chartDataProviderService: ChartDataProviderService) {
  }

  ngOnInit() {
    var subscription = this.chartDataProviderService.fetchChartData()
      .subscribe((data: ChartResponse) => {
        this.chartData = data;
        subscription.unsubscribe();
      });
  }

}
