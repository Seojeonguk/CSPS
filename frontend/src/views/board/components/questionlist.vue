<template lang="">
  <div class="question-list row" @click="mvQuestion()">
    <q-icon class="question-list-icon" name="auto_stories" />
    <div class="question-list-info">
      <div class="list-title">{{ question.title }}</div>
      <div class="list-createdAt">{{ question.createdAt }}</div>
      <div class="list-userinfo">
        <div class="list-user-image">{{ question.user.image }}</div>
        <!-- <div class="list-user-name">{{ question.user.name }}</div> -->
        <div class="list-user-nickName">{{ question.user.nickName }}</div>
      </div>
    </div>
  </div>
</template>
<script>
import { useRouter } from "vue-router";

export default {
  name: "question-list",
  props: {
    question: { type: Object },
  },
  setup(props) {
    console.log(props.question);
    const router = useRouter();

    const mvQuestion = () => {
      router.push({
        name: "board-question",
        params: {
          id: props.question.id,
          title: props.question.title,
          description: props.question.description,
          createdAt: props.question.createdAt,
          user: props.question.user,
        },
      });
    };
    return {
      useRouter,
      mvQuestion,
    };
  },
};
</script>
<style></style>
