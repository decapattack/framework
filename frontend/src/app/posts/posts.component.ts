import { Component, OnInit } from '@angular/core';
import { HttpClientService, Post } from '../service/http-client.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts: string[];

  constructor(private httpClientService: HttpClientService) { }

  ngOnInit() {
    this.httpClientService.getPosts().subscribe(
     response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response){
    this.posts = response;
  }

  deletePost(post: Post): void {
    this.httpClientService.deletePost(post)
      .subscribe( data => {
        this.posts = this.posts.filter(u => u );
      });
  }

}
