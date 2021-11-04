<template lang="">
  <div style="overflow: auto; width: 100%; height: 100%">
    <teamplate
      v-for="(category, index) in state.problemResults"
      :key="index"
      unelevated
    >
      <h4>
        <b>{{ index + 1 }}. {{ state.problems[index].description }}</b>
      </h4>
      <div class="row">
        <div class="col" style="margin-left: 155px">
          <h6><b>정답율</b></h6>
          <apexchart
            width="340"
            :options="chartOptions"
            type="donut"
            :series="state.series[index]"
          />
        </div>
        <div class="col" style="margin: 85px">
          <h5 style="color: blue"><b>언급 단어</b></h5>
          <teamplate v-for="item in category.proper" v-bind:key="item">
            <b>{{ item }}</b>
            &nbsp;
          </teamplate>
          <h5 style="color: green"><b>미언급 단어</b></h5>
          <teamplate v-for="item in category.wrong" v-bind:key="item">
            <b>{{ item }}</b>
            &nbsp;
          </teamplate>
        </div>
      </div>
    </teamplate>
    <br />
    <!-- <q-btn unelevated flat @click="check()">체크</q-btn> -->
    <q-btn unelevated flat @click="check()">뒤로가기</q-btn>
  </div>
</template>
<script>
import { useStore } from "vuex";
import { computed, reactive } from "vue";
import { useRouter } from "vue-router";
export default {
  name: "problem-result",
  data() {
    return {
      chartOptions: {
        chart: {
          width: 380,
          type: "pie",
        },
        labels: ["언급", "미언급"],
        responsive: [
          {
            breakpoint: 480,
            options: {
              chart: {
                width: 200,
              },
              legend: {
                position: "bottom",
              },
            },
          },
        ],
      },
    };
  },

  setup() {
    const store = useStore();
    const router = useRouter();
    const state = reactive({
      problemResults: computed(() => store.getters["root/getProblemResults"]),
      problems: computed(() => store.getters["root/getSelectedProblems"]),
      series: computed(() => store.getters["root/getSeries"]),
    });

    const backToInfo = () => {
      store.commit("root/setProblemResultsInit");
      router.push({
        name: "problem",
      });
    };

    return {
      state,
      backToInfo,
    };
  },
  methods: {
    check() {
      this.$router.push({ name: "problem-info" });
    },
  },
};
</script>
<style></style>
