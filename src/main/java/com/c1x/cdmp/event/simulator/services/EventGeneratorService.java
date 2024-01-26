package com.c1x.cdmp.event.simulator.services;
import com.c1x.cdmp.event.simulator.mockDataStore.Event;
import com.c1x.cdmp.event.simulator.mockDataStore.EventEnum;
import com.c1x.cdmp.event.simulator.mockDataStore.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.*;

@Service
public class EventGeneratorService {
    private final WebClient webClient;
    public EventGeneratorService() {
        this.webClient = WebClient.create("");
    }

    public static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("エスコ", 0, "", 2467167, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50476143-210909-02.jpg", "/g/02467167/", "9x23mm 歯ブラシ(10本)", 1, 290, 1, 2.0, 319, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2432777, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50385396-210517-02.jpg", "/g/02432777/", "M 3-M12 タップドリルセット", 4, 4500, 1, 2.75, 4950, 0.1, 1));
        products.add(new Product("モノタロウ", 1, "", 31236, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono07331143-060105-02.jpg", "/g/00031236/", "粘着マット", 103, 1390, 6, 4.33981, 1529, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 77525, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03408386-140620-02.jpg", "/g/00077525/", "コテ型ブラシ[スチール]", 13, 1040, 1, 0.0, 1144, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 8760, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50385414-220406-02.jpg", "/g/02432778/", "M 3-M12 タップダイスセット(並目/細目)", 1, 8760, 2, 4.0, 9636, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2467092, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50474664-220704-02.jpg", "/g/02467092/", "19 x177mm パーツブラシ", 3, 190, 1, 4.66667, 209, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 82273, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03625063-221111-02.jpg", "/g/00082273/", "軸付き砥石", 2, 1620, 2, 4.0, 1782, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2400784, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono49992985-230522-02.jpg", "/g/02400784/", "1/2\" パイプエキストラクター", 2, 3150, 1, 4.5, 3465, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2432782, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50385502-170420-02.jpg", "/g/02432782/", "タップダイスセット(MM/UNC/UNF)", 2, 13700, 1, 4.5, 15070, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 81471, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03605095-220329-02.jpg", "/g/00081471/", "75mm カップ型ワイヤーブラシ", 3, 2400, 1, 4.66667, 2640, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2467166, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50476125-170510-02.jpg", "/g/02467166/", "160mm ナイロンブラシ(10本)", 0, 1060, 1, 0.0, 1166, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 82216, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03621134-150907-02.jpg", "/g/00082216/", "25x25mm [橙] 6mm軸付砥石", 0, 370, 1, 0.0, 407, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 82727, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03472287-180824-02.jpg", "/g/00082727/", "[粗目] 50x25x150mm 油砥石", 1, 3460, 1, 3.0, 3806, 0.1, 1));
        products.add(new Product("タンガロイ", 1, "", 3716, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono00698215-210804-02.jpg", "/g/00003716/", "チップ TNGGR/L-C", 5, 7590, 36, 4.2, 8349, 0.1, 1));
        products.add(new Product("サンドビック", 1, "", 20631, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono05587075-131009-02.jpg", "/g/00020631/", "折れ込みタップ除去工具(ハードカットドリル)", 9, 2990, 5, 3.55556, 3289, 0.1, 1));
        products.add(new Product("エスコ", 0, "", 2467171, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50476222-220630-02.jpg", "/g/02467171/", "8x180mm 柄付ブラシ(ナイロン製/3本)", 1, 620, 1, 5.0, 682, 0.1, 1));
        products.add(new Product("エスコ", 1, "", 76073, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono03440927-130313-02.jpg", "/g/00076073/", "#800 耐水ペーパー", 1, 430, 2, 5.0, 473, 0.1, 1));
        products.add(new Product("モノタロウ", 1, "", 2466337, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono50009968-161209-02.jpg", "/g/02466337/", "研磨ディスク アルミナ", 163, 139, 20, 4.48466, 153, 0.1, 1));
        products.add(new Product("モノタロウ", 0, "", 29436, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono07213945-171107-02.jpg", "/g/00029436/", "研磨ベルト アルミナ 幅10mm 長さ330mm", 370, 499, 10, 3.57027, 549, 0.1, 1));
        products.add(new Product("モノタロウ", 1, "", 155270, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono08459351-190816-02.jpg", "/g/00155270/", "研磨パッド #320", 218, 999, 2, 4.42202, 1099, 0.1, 1));
        products.add(new Product("モノタロウ", 0, "", 2896020, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono68712123-210204-02.jpg", "/g/02896020/", "六角軸ドリル&ステップドリルセット TiNコート", 147, 1590, 1, 4.10204, 1749, 0.1, 1));
        products.add(new Product("サンドビック", 1, "", 540671, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono16485008-190304-02.jpg", "/g/00540671/", "カウンターシンクヘッドスクリュー", 0, 73, 99, 0.0, 80, 0.1, 1));
        products.add(new Product("タンガロイ", 1, "", 174851, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono09150172-191025-02.jpg", "/g/00174851/", "クランプ式スクレーパ", 2, 3290, 4, 5.0, 3619, 0.1, 1));
        products.add(new Product("タンガロイ", 1, "", 694394, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono04757706-151105-02.jpg", "/g/00694394/", "外径用ホルダ ETGNR/L", 0, 5390, 10, 0.0, 5929, 0.1, 1));
        products.add(new Product("タンガロイ", 1, "", 1251597, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono00699475-181018-02.jpg", "/g/01251597/", "チップ TPGA", 0, 7490, 9, 0.0, 8239, 0.1, 1));
        products.add(new Product("タンガロイ", 1, "", 399327, "https://jp.images-monotaro.com/Monotaro3/pi/full/mono19060353-190219-02.jpg", "/g/00399327/", "チップ IR/L-ISO", 0, 4390, 34, 0.0, 4829, 0.1, 1));
        return products;
    }

    public static <T> List<T> pickRandomObjects(List<T> originalList) {
        Random random = new Random();

        // Determine the number of objects to pick randomly
        int m = Math.max(1, random.nextInt(originalList.size() + 1));

        // Create a new list to hold the randomly selected objects
        List<T> randomObjects = new ArrayList<>();

        // Copy the original list to avoid modifying it
        List<T> copyOfOriginal = new ArrayList<>(originalList);

        // Pick m random elements from the original list
        for (int i = 0; i < m; i++) {
            int randomIndex = random.nextInt(copyOfOriginal.size());
            randomObjects.add(copyOfOriginal.remove(randomIndex));
        }

        return randomObjects;
    }



    public static Flux<Event> generateRandomEvents(int n, EventEnum eventType) {
        return Flux.range(0, n)
                .flatMap(i -> Mono.fromCallable(() -> {
                    Event event = new Event();
                    event.setUserId(generateUserId(n));
                    if (eventType == null) {
                        EventEnum[] eventTypes = EventEnum.values();
                        EventEnum randomEventType = eventTypes[new Random().nextInt(eventTypes.length)];
                        event.setEvent(randomEventType);
                    } else {
                        event.setEvent(eventType);
                    }

                    event.setType("track");
                    event.setTimestamp(generateRandomTimestamp());
                    List<Product> randomProducts = pickRandomObjects(initializeProducts());
                    event.setProductList(randomProducts);

                    return event;
                }));
    }


    private static Date generateRandomTimestamp() {
        return new Date();
    }

    private static String generateUserId(int n) {
        return "user_" + new Random().nextInt( n/2);
    }

    public static Mono<Void> sendEventToExternalSystem(Event event) {
        String apiUrl = "http://localhost:8080/api/v1/events/test";

        if (apiUrl == null || apiUrl.isEmpty()) {
            throw new IllegalStateException("API_URL environment variable is not set.");
        }

        return WebClient.create()
                .post()
                .uri(apiUrl)
                .body(BodyInserters.fromValue(event))
                .retrieve()
                .bodyToMono(Void.class);
    }

//    public Mono<Void> sendEventToExternalSystem(Event event) {
//        Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(event));
//        return Mono.empty();
//    }

    public Flux<Void> generateAndSendRandomEvents(int numberOfEvents) {
        return generateRandomEvents(numberOfEvents, null)
                .flatMap(event -> sendEventToExternalSystem(event)
                        .doOnSuccess(response -> {
                            // Handle the response if needed
                            System.out.println("Network call successful for event: " + event);
                            System.out.println();
                        })
                        .doOnError(error -> {
                            // Handle the error if the network call fails
                            System.err.println("\nNetwork call failed for event: " + event);
                        })
                );
    }

}