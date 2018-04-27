export class Quiz {
  constructor(
    public title: string,
    public timeLimit: number,
    public category: string,
    public status: string // public questions?: Question[]
  ) {}
}

export class Question {
  public body = "";
  public choicea = "";
  public choiceb = "";
  public choicec = "";
  public choiced = "";
  public correct_answer = "";
  public number: number;
  public points: number;
  public type: number;
/**
  sampleQ = [
    {
      body: "Sample Q1",
      choicea: "sample a",
      choiceb: "sample b",
      choicec: "sample c",
      choiced: "sample d",
      correct_answer: "a",
      number: 7,
      points: 10,
      type: 1
    }
  ];
*/
  makeNewQuestion(
    given_body,
    given_a,
    given_b,
    given_c,
    given_d,
    given_correct,
    given_num,
    given_points,
    given_type
  ) {
    this.body = given_body;
    this.choicea = given_a;
    this.choiceb = given_b;
    this.choicec = given_c;
    this.choiced = given_d;
    this.correct_answer = given_correct;
    this.number = given_num;
    this.points = given_points;
    this.type = given_type;
    return this;
  }

  makeNewSimpleQuestion(
    given_body,
    given_correct,
    given_num,
    given_points,
    given_type
  ) {
    this.body = given_body;
    this.correct_answer = given_correct;
    this.number = given_num;
    this.points = given_points;
    this.type = given_type;
    return this;
  }

}
