FROM nvidia/cuda:11.8.0-runtime-ubuntu20.04

RUN apt-get update && apt-get install -y --no-install-recommends \
      python3-pip \
      python3 \
      git \
      curl \
      build-essential \
      rustc \
      cargo && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

RUN python3 -m pip install --upgrade pip && python3 -m pip install vllm

EXPOSE 8000

CMD ["vllm", "serve", "gpt2", "--device", "cuda"]
