import { Component, OnInit } from '@angular/core';
import { HttpClientService, Post, User, Comment } from '../service/http-client.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  post: Post;
  user: string;
  comments: any[];
  isDataAvailable = false;

  constructor(private httpClientService: HttpClientService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.comments = [];
    this.route.params.subscribe(params => {
      const id = params.id;
      this.httpClientService.getPost(id).subscribe(
        response => this.handleSuccessfulResponse(response),
      );
  });
  }

  handleSuccessfulResponse(response){
    this.post = response;
    this.user = this.post.user;
    this.comments = this.post.comentarios;
    this.isDataAvailable = true;
  }
}
