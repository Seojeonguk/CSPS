<template lang="">
  <div class="question-answer">
    <div class="answer">
      <div class="answer-user-image">
        <img :src="state.answer.user.image" class="answer-user-image-circle" />
      </div>
      <div class="answer-top">
        <div class="answer-user">
          <div class="answer-user-nickname">
            {{ state.answer.user.nickName }}
          </div>
          <div class="answer-user-createdAt">
            {{ state.answer.createdAt }}
          </div>
        </div>
        <div class="answer-bottom">
          <div class="answer-content">
            {{ state.answer.content }}
          </div>
          <div v-if="state.comment != null">
            <answer-comment
              v-for="(comment, index) in state.comment"
              :key="index"
              :comment="comment"
            ></answer-comment>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import "@/styles/question.scss";
import AnswerComment from "./components/comment.vue";

import { reactive } from "vue";
export default {
  name: "question-answer",
  components: {
    AnswerComment,
  },
  props: {
    answer: Object,
    comment: Array,
  },
  setup(props) {
    const state = reactive({
      answer: null,
      comment: null,
    });
    const setAnswer = () => {
      state.answer = props.answer;
    };
    setAnswer();
    const setComment = () => {
      let comment = props.comment;
      state.comment = comment.filter(
        (comment) => state.answer.id == comment.parentId
      );
      console.log(state.comment);
    };
    setComment();

    return {
      state,
    };
  },
};
</script>
<style lang=""></style>
