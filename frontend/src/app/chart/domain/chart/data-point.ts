export class DataPoint {
  constructor(public x:number, public y:number) {
  }

  public toString(): string {
    return this.x + '\t' + this.y;
  }
}
