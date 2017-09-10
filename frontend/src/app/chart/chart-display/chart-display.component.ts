import { Component, Input, OnInit } from '@angular/core';
import { ChartDataProviderService } from '../service';
import { ChartResponse } from '../domain';

@Component({
  selector: 'app-chart-display',
  templateUrl: './chart-display.component.html',
  styleUrls: ['./chart-display.component.css']
})
export class ChartDisplayComponent implements OnInit {
  @Input()
  public chartData: ChartResponse;

  ngOnInit() {
  }

}
