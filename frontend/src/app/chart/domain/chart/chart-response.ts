import {DataPoint} from './data-point';

export class ChartResponse {
  constructor(public legendX: string, public legendY: string, public message: string, public entries: DataPoint[]) {
  }

  public toString(): string {
    return 'ChartResponse: ' + this.legendX + '\t' + this.legendY + '\t' + this.message + '\t' + this.entries;
  }
}
