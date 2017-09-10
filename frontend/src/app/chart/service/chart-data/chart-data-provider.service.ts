import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { PlatformLocation } from '@angular/common';
import { ChartResponse } from '../../domain';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ChartDataProviderService {
  private chartData: string = '';

  constructor(private http: Http, private locator: PlatformLocation) {
    console.log(locator.getBaseHrefFromDOM());
    console.log(locator.pathname);
  }

  fetchChartData(): Observable<ChartResponse> {
    return this.http.get(this.locator.getBaseHrefFromDOM() + "recentChartData")
      .map((response: Response) => response.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}
