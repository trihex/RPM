export class Outcome {
  id:number;
  result:string;
  reason:string;
  primaryRole:number;

  constructor(id:number, result:string, reason:string, primaryRole:number)
  {
    this.id = id;
    this.result = result;
    this.reason = reason;
    this.primaryRole = primaryRole;
  }
}
