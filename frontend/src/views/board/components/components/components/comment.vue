<template lang="">
  <div class="comment-user-image">
    <img :src="state.comment.user.image" />
  </div>
  <div class="comment-info">
    <div class="comment-user">
      <div class="comment-user-nickname">
        {{ state.comment.user.nickName }}
      </div>
      <div class="comment-user-createdAt">{{ state.comment.createdAt }}</div>
    </div>
    <div class="comment-content">
      {{ state.comment.content }}
    </div>
  </div>
</template>
<script>
import { reactive } from "vue";
export default {
  name: "question-answer-comment",
  props: {
    comment: Object,
  },
  setup(props) {
    const state = reactive({
      comment: null,
    });
    const setComment = () => {
      state.comment = props.comment;
    };
    setComment();
    const setCreatedAt = () => {
      state.comment.createdAt =
        state.comment.createdAt.split("T")[0] +
        " " +
        state.comment.createdAt.split("T")[1];
    };
    setCreatedAt();
    return {
      state,
    };
  },
};
</script>
<style lang=""></style>
