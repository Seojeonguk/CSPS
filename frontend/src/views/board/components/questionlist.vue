<template lang="">
  <div>
    <div>
      <q-btn @click="getBoardInfo()">
        <div>
          <div id="title">
            <q-question-label>{{ question.title }}</q-question-label>
            <q-question-label caption lines="2">{{
              question.createdAt
            }}</q-question-label>
          </div>
        </div>
      </q-btn>
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
    const router = useRouter();

    const getBoardInfo = () => {
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
      getBoardInfo,
    };
  },
};
</script>
<style></style>
