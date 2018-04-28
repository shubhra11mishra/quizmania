import { Injectable, Component, OnInit, OnChanges } from "@angular/core";
import { QuizService } from "../shared";
import { HttpClient } from "@angular/common/http";
import { ActivatedRoute, Params, Router } from "@angular/router";
import { Http, Response, RequestOptions, Headers } from "@angular/http";
import {
  FormControlName,
  FormArray,
  FormBuilder,
  FormGroup,
  Validators
} from "@angular/forms";
import { Quiz, Question } from "../quiz";
import { sample } from "rxjs/operators";

@Component({
  selector: "app-addquestions",
  templateUrl: "./addquestions.component.html",
  styleUrls: ["./addquestions.component.css"],
  providers: [QuizService, Question]
})
@Injectable()
export class AddQuestionsComponent implements OnInit, OnChanges {
  // demoQ = new Question('q1', 'a', 'b', 'c', 'd', 'a', 1, 10, 1);
  userId;
  quizId;

  // yet to be used
  oldQuestions;
  // final questions to save
  fullQuestions;
  questionForm: FormGroup;
  q1;
  // stores current questions from front-end
  currentQuestions;
  // stores types of each question on front-end, used to display the right fields on the front-end
  mcQ = [];
  endURL;
  message = "";
  submitted = false;
  newForm = false;

  constructor(
    private fb: FormBuilder,
    private http: Http,
    private quizService: QuizService,
    private router: Router,
    private question: Question,
    private route: ActivatedRoute
  ) {
    // <--- inject FormBuilder
    this.createForm();
  }

  createForm() {
    // number and quizID not handled yet
    this.newForm = true;
    this.submitted = false;
    this.questionForm = this.fb.group({
      questions: this.fb.array([])
      // question: this.fb.group(new Question())
    });
  }

  setQuestions(questions: Question[]) {
    const questionFGs = questions.map(question => this.fb.group(question));
    const questionFormArray = this.fb.array(questionFGs);
    this.questionForm.setControl("questions", questionFormArray);
    console.log("finished setting sample questions.");
  }

  get questions(): FormArray {
    return this.questionForm.get("questions") as FormArray;
  }

  /**
   question: ["", Validators.required], // <--- a FormControl called "question"
      choiceA: "",
      choiceB: "",
      choiceC: "",
      choiceD: "",
      correctAnswer: ["", Validators.required],
      points: [5, Validators.required],
      type: [1, Validators.required]
  */
  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params["userid"];
      this.quizId = params["id"];
      this.oldQuestions = this.quizService.getAllQuestions(
        this.userId,
        this.quizId
      );
      console.log(this.userId);
    });
  }

  getCurrentQuestions() {
    this.currentQuestions = this.questionForm.get("questions") as FormArray;
    return this.currentQuestions;
  }

  ngOnChanges() {
    this.resetForm();
    // getCurrentQuestions();
  }

  resetForm() {
    this.q1 = this.question.makeNewQuestion(
      "sample q :)",
      "a",
      "b",
      "c",
      "d",
      "a",
      1,
      10,
      0
    );
    const sample_questions = [];
    sample_questions.push(this.q1);

    // this.questionForm.reset({
    // question: this.q1
    // this.setQuestions(sample_questions);
    this.createForm();
  }
  // this.questions = [];

  addMCQuestion() {
    this.newForm = false;
    this.mcQ.push(true);
    // this.q1 = this.question.makeNewQuestion(
    //   "sample q :)",
    //   "a",
    //   "b",
    //   "c",
    //   "d",
    //   "a",
    //   1,
    //   10,
    //   null
    // );
    // this.questions.push(this.fb.group(this.q1));
    this.questions.push(
      this.fb.group(
        this.question.makeNewQuestion("", "", "", "", "", "", null, null, 1)
      )
    );
  }

  addEssayQuestion() {
    this.newForm = false;
    this.mcQ.push(false);
    // this.q1 = this.question.makeNewSimpleQuestion('sample essay question...', 'correct!', 2, 15, 2);
    this.questions.push(
      this.fb.group(this.question.makeNewSimpleQuestion("", "", null, null, 2))
    );
  }

  removeQuestion(index) {
    this.questions.removeAt(index);
    if (this.questions.length === 0) {
      this.newForm = true;
    }
    this.mcQ.splice(index, 1);
  }

  prepareSaveQuestions() {
    const formValues = this.questionForm.value;

    const questionsDeepCopy: Question[] = formValues.questions.map(
      (question: Question) => Object.assign({}, question)
    );

    return questionsDeepCopy;
  }

  onSubmit() {
    this.fullQuestions = this.prepareSaveQuestions();
    this.resetForm();
    // this.quizService
    //   .updateQuiz(this.userId, this.quizId, this.fullQuestions)
    //   .subscribe(
    //     // console.log('called update quiz in quiz service ts')
    //   );

    console.log("hmm...adding questions");
    const headers = new Headers({
      "Content-Type": "application/json"
    });

    const options = new RequestOptions({
      headers: headers
    });
    this.submitted = true;
    this.newForm = false;
    this.endURL =
      "http://localhost:4200/quizmania/examiner/" +
      this.userId +
      "/quiz/" +
      this.quizId +
      "/addQuestions";
    return this.http
      .post(this.endURL, this.fullQuestions, options)
      .toPromise()
      .then((good: Response) => {
        console.log("added questions to quiz!");
        if (good === null) {
          this.message =
            "Quiz does not exist! Please create one and add questions. ";
          console.log("data is null");
        }
        console.log("re-directing user...");
        this.endURL = "http://localhost:8080/examiner-dashboard/" + this.userId;
        console.log("done in add questions ts");
        return this.http.get(this.endURL);
      })
      .catch((error: Response | any) => {
        console.log("hm, error adding questions :(");
        console.log(error);
        return Promise.reject(error);
      });
  }

  revert() {
    this.resetForm();
  }

  goBack() {
    this.endURL = "/examiner/" + this.userId + "/viewmyquizzes";
    this.router.navigate([this.endURL]);
  }
}
