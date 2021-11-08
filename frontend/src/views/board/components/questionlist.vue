<template lang="">
  <div class="question-list" @click="mvQuestion()">
    <q-icon class="question-list-icon" name="auto_stories" />
    <div class="question-list-info">
      <div class="list-title">
        {{ question.title }}
      </div>
      <div class="list-createdAt">{{ question.createdAt }}</div>
      <div class="list-userinfo">
        <div class="list-user-image">
          <img class="user-image-circle" :src="question.user.image" />
        </div>
        <div class="list-user-nickName">
          {{ question.user.nickName }}
          <q-tooltip>{{ question.user.nickName }}</q-tooltip>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { useStore } from "vuex";
import { useRouter } from "vue-router";

export default {
  name: "question-list",
  props: {
    question: Object,
  },
  setup(props) {
    const router = useRouter();
    const store = useStore();

    const mvQuestion = () => {
      console.log("mvQuestion", props.question.id);
      store
        .dispatch("root/requsetBoardInfo", props.question.id)
        .then(
          (response) => {
            console.log(response.data);
            router.push({
              name: "board-question",
              params: {
                question: {
                  id: response.data.id,
                  title: response.data.title,
                  description: response.data.description,
                  createdAt: response.data.createdAt,
                  user: response.data.user,
                  answerComment: response.data.answerComment,
                  coComment: response.data.coComment,
                },
              },
            });
          },
          (error) => {
            console.log(error);
          }
        )
        .catch((error) => {
          console.log(error);
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
