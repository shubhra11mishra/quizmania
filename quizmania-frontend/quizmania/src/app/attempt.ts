export class Attempt {
  constructor(
    public count: number,
  ) {}
}

export class UserResponse {
  public resp = "";

  makeNewResponse(
    given_resp
  ) {
    this.resp = given_resp;
    return this;
  }

}
