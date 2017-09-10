import { Component, Input, OnInit } from '@angular/core';
import { ChartDataProviderService } from '../service';
import { ChartResponse, DataPoint } from '../domain';
import { ChartsModule } from 'ng2-charts';

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

  public lineChartData(): number[] {
    return this.chartData.entries.map((entry: DataPoint) => entry.y).slice(0);
  }

  public lineChartLabels(): Array<any> {
    return this.chartData.entries.map((entry: DataPoint) => entry.x).slice(0);
  }

  public lineChartOptions:any = {
    responsive: false,
    maintainAspectRatio: false,
    tooltips: {
      enabled: false
    }
  };
  public lineChartColors:Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend:boolean = false;
  public lineChartType:string = 'line';


  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }
}
