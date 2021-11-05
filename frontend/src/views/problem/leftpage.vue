<template>
  <div class="left-wrap">
    <div class="open-left-wrap">
      <div>
        <q-btn flat @click="mvProblemInfo"><b>문제카테고리</b></q-btn>
      </div>
      <div class="s1_arrow" style="margin-bottom: 8px">
        <div class="scroll-arrow"></div>
        <div class="scroll-arrow"></div>
      </div>
      <div class="column justify-center item-center">
        <q-btn
          v-for="(category, index) in state.categories"
          :key="index"
          unelevated
          flat
          @click="mvProblemDescription(category)"
          ><b>{{ category.name }}</b>
          <q-tooltip>{{ category.description }}</q-tooltip>
        </q-btn>
        <br />
      </div>
    </div>
  </div>
</template>

<script>
import { useStore } from "vuex";
import { computed, reactive } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "problem-left",
  setup() {
    const store = useStore();
    const router = useRouter();
    const state = reactive({
      categories: computed(() => store.getters["root/getCategories"]),
    });

    const mvProblemDescription = (category) => {
      store
        .dispatch("root/requestProblemNumInCategory", category.id)
        .then((response) => {
          router.push({
            name: "problem-description",
            params: {
              id: category.id,
              description: category.description,
              name: category.name,
              size: response.data,
            },
          });
        });
    };
    const mvProblemInfo = () => {
      router.push({ name: "problem-info" });
    };

    return {
      state,
      mvProblemDescription,
      mvProblemInfo,
    };
  },
};
</script>
<style scoped>
.s1_arrow {
  display: inline-block;
  position: relative;
  top: 30px;
  margin: -35px;
  text-align: center;
  animation: arrow_down 2.5s infinite;
}
.scroll-arrow {
  width: 15px;
  height: 15px;
  border-right: 4px solid gray;
  border-bottom: 4px solid gray;
  transform: rotate(45deg);
  -webkit-transform: rotate(45deg);
  -moz-transform: rotate(45deg);
  -o-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  animation: arrow-wave 1s infinite;
  animation-direction: alternate;
}
.scroll-arrow:nth-child(1) {
  animation-delay: 0.1s;
}
.scroll-arrow:nth-child(2) {
  margin-top: 1px;
  animation-delay: 0.2s;
  margin-bottom: 32px;
}
.scroll-arrow:nth-child(3) {
  margin-top: 8px;
  animation-delay: 0.3s;
}
@keyframes arrow-wave {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.5;
  }
  100% {
    opacity: 1;
  }
}
@keyframes arrow_down {
  0% {
    top: 8px;
  }
  50% {
    top: 40px;
  }
  100% {
    top: 28px;
  }
}
</style>
