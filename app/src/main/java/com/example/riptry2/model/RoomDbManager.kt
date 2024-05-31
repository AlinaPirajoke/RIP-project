package com.example.riptry2.model

import android.content.Context
import androidx.room.Room
import com.example.riptry2.viewmodels.states.ApplicationState
import com.example.riptry2.viewmodels.states.ProductState
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus
import com.example.riptry2.viewmodels.states.utils.ListOptionModel
import com.example.riptry2.viewmodels.states.utils.RequiredProduct
import com.example.riptry2.viewmodels.states.utils.joinToRequiredProduct
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomDbManager(context: Context) {

    private val appDatabase: MainDatabase by lazy {
        Room.databaseBuilder(context, MainDatabase::class.java, "database")
            .build()
    }
    private val dao = appDatabase.getMainDao()

    init {
        GlobalScope.launch {
            /*dao.insertProduct(
                ProductEntity(
                    title = "Кофемашина Delonghi",
                    description = "Автоматическая кофемашина с возможностью приготовления эспрессо и капучино.",
                    left = 199
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Умные часы WatchIt",
                    description = "Водонепроницаемые умные часы с функцией мониторинга сердечного ритма.",
                    left = 150
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Беспроводные наушники SoundMax",
                    description = "Наушники с шумоподавлением и долгим временем автономной работы.",
                    left = 130
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Электросамокат Speedster",
                    description = "Складной электросамокат с максимальной скоростью до 25 км/ч.",
                    left = 180
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Робот-пылесос CleanBot",
                    description = "Автоматический робот-пылесос с функцией влажной уборки.",
                    left = 170
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Умная лампа Bright",
                    description = "LED-лампа с возможностью управления через смартфон.",
                    left = 50
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Электрогриль BBQPro",
                    description = "Стационарный электрогриль для приготовления шашлыков и стейков.",
                    left = 120
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Фитнес-браслет HealthTrack",
                    description = "Фитнес-браслет с функциями отслеживания активности и сна.",
                    left = 80
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Портативный проектор MiniCinema",
                    description = "Компактный проектор для домашнего кинотеатра с поддержкой Full HD.",
                    left = 200
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Виртуальные очки VRDream",
                    description = "Очки виртуальной реальности для погружения в мир игр и развлечений.",
                    left = 90
                )
            )

            listOf(
                AnnouncementEntity(id = 1, title = "Поставка электроники", description = "Необходимо обеспечить своевременную поставку электроники для крупного ритейлера. Срок поставки не должен превышать 2 недель с момента подписания контракта.", status = ApplicationStatus.INCOME.status),
                AnnouncementEntity(id = 2, title = "Поставка мебели", description = "Требуется поставка офисной мебели для нового офиса компании. Ожидается высокое качество продукции и доставка в течение месяца.", status = ApplicationStatus.ACTIVE.status),
                AnnouncementEntity(id = 3, title = "Поставка строительных материалов", description = "Запрос на регулярную поставку строительных материалов для крупного проекта по возведению жилого комплекса. Поставка должна быть поэтапной и завершиться в течение 3 месяцев.", status = ApplicationStatus.DONE.status),
                AnnouncementEntity(id = 4, title = "Поставка продуктов питания", description = "Необходимо организовать регулярные поставки свежих продуктов питания в сеть супермаркетов. Поставки должны осуществляться еженедельно в течение 6 месяцев.", status = ApplicationStatus.INCOME.status),
                AnnouncementEntity(id = 5, title = "Поставка канцелярских товаров", description = "Требуется обеспечение канцелярскими товарами для офиса. Ожидается единоразовая поставка с завершением в течение 2 недель.", status = ApplicationStatus.ACTIVE.status),
                AnnouncementEntity(id = 6, title = "Поставка бытовой химии", description = "Запрос на поставку бытовой химии для сети магазинов. Требуется обеспечить завершение поставки в течение месяца.", status = ApplicationStatus.ACTIVE.status),
                AnnouncementEntity(id = 7, title = "Поставка одежды и обуви", description = "Необходимо организовать поставку одежды и обуви для нового сезона. Ожидается завершение поставки в течение 2 месяцев.", status = ApplicationStatus.ACTIVE.status),
                AnnouncementEntity(id = 8, title = "Поставка медицинских товаров", description = "Требуется срочная поставка медицинских товаров для больницы. Доставка должна быть осуществлена в течение 1 недели.", status = ApplicationStatus.DONE.status),
                AnnouncementEntity(id = 9, title = "Поставка спортивного инвентаря", description = "Запрос на поставку спортивного инвентаря для фитнес-клуба. Ожидаемая дата завершения поставки - в течение 1 месяца.", status = ApplicationStatus.INCOME.status),
                AnnouncementEntity(id = 10, title = "Поставка компьютерных комплектующих", description = "Необходимо обеспечить поставку компьютерных комплектующих для сборки компьютеров. Требуется завершение поставки в течение 3 недель.", status = ApplicationStatus.INCOME.status)
            ).forEach {
                dao.insertAnnouncement(it)
            }*/

//            listOf(
////                AnnouncementProductEntity(productId = 10, applicationId = 1, quantity = 10),
//                AnnouncementProductEntity(productId = 1, applicationId = 1, quantity = 20),
//                AnnouncementProductEntity(productId = 2, applicationId = 1, quantity = 30),
//                AnnouncementProductEntity(productId = 3, applicationId = 2, quantity = 15),
//                AnnouncementProductEntity(productId = 4, applicationId = 2, quantity = 25),
//                AnnouncementProductEntity(productId = 5, applicationId = 2, quantity = 35),
//                AnnouncementProductEntity(productId = 6, applicationId = 3, quantity = 40),
//                AnnouncementProductEntity(productId = 7, applicationId = 3, quantity = 45),
//                AnnouncementProductEntity(productId = 8, applicationId = 3, quantity = 50),
//                AnnouncementProductEntity(productId = 9, applicationId = 4, quantity = 72),
//                AnnouncementProductEntity(productId = 10, applicationId = 4, quantity = 22),
//                AnnouncementProductEntity(productId = 1, applicationId = 4, quantity = 92),
//                AnnouncementProductEntity(productId = 2, applicationId = 5, quantity = 18),
//                AnnouncementProductEntity(productId = 3, applicationId = 5, quantity = 28),
//                AnnouncementProductEntity(productId = 4, applicationId = 5, quantity = 38),
//                AnnouncementProductEntity(productId = 5, applicationId = 6, quantity = 8),
//                AnnouncementProductEntity(productId = 6, applicationId = 6, quantity = 16),
//                AnnouncementProductEntity(productId = 7, applicationId = 6, quantity = 74),
//                AnnouncementProductEntity(productId = 8, applicationId = 7, quantity = 6),
//                AnnouncementProductEntity(productId = 9, applicationId = 7, quantity = 14),
//                AnnouncementProductEntity(productId = 10, applicationId = 7, quantity = 26),
//                AnnouncementProductEntity(productId = 1, applicationId = 8, quantity = 33),
//                AnnouncementProductEntity(productId = 2, applicationId = 8, quantity = 141),
//                AnnouncementProductEntity(productId = 3, applicationId = 8, quantity = 9),
//                AnnouncementProductEntity(productId = 4, applicationId = 9, quantity = 11),
//                AnnouncementProductEntity(productId = 5, applicationId = 9, quantity = 43),
//                AnnouncementProductEntity(productId = 6, applicationId = 9, quantity = 15),
//                AnnouncementProductEntity(productId = 7, applicationId = 10, quantity = 21),
//                AnnouncementProductEntity(productId = 8, applicationId = 10, quantity = 203),
//                AnnouncementProductEntity(productId = 9, applicationId = 10, quantity = 27),
//                AnnouncementProductEntity(productId = 11, applicationId = 4, quantity = 37),
//                AnnouncementProductEntity(productId = 11, applicationId = 3, quantity = 67),
//                AnnouncementProductEntity(productId = 11, applicationId = 8, quantity = 47),
//            ).forEach {
//                dao.insertRequired(it)
//            }
        }
    }


    suspend fun insertProduct(product: ProductEntity) =
        dao.insertProduct(product)

    suspend fun updateProduct(product: ProductEntity) =
        dao.updateProduct(product)

    suspend fun getProductInfo(productId: Int): ProductState =
        dao.getProduct(productId).mapToProductState()

    suspend fun getProductList(): ArrayList<ListOptionModel> {
        val models = arrayListOf<ListOptionModel>()

        dao.getProductsList().forEach { models.add(it.mapToListModel()) }
        return models
    }


    suspend fun insertAnnouncement(announcement: AnnouncementEntity) =
        dao.insertAnnouncement(announcement)

    suspend fun updateAnnouncement(announcement: AnnouncementEntity) =
        dao.updateAnnouncement(announcement)

    suspend fun deleteAnnouncement(announcement: AnnouncementEntity) =
        dao.deleteAnnouncement(announcement)

    suspend fun getAnnouncementInfo(announcementId: Int): ApplicationState {
        val announcement = dao.getAnnouncement(announcementId)
        val requiredList = getRequired(announcementId)
        val requiredProducts = arrayListOf<RequiredProduct>()

        requiredList.forEach {
            val product = dao.getProduct(it.productId)
            requiredProducts.add(joinToRequiredProduct(it, product))
        }

        return announcement.mapToApplicationState(requiredProducts)
    }

    suspend fun getAnnouncementsList(status: ApplicationStatus): ArrayList<ListOptionModel> {
        val models = arrayListOf<ListOptionModel>()

        dao.getAnnouncementsList(status.status).forEach { models.add(it.mapToListModel()) }
        return models
    }

    suspend fun getActiveAnnouncementsList(): ArrayList<ListOptionModel> =
        getAnnouncementsList(ApplicationStatus.ACTIVE)

    suspend fun getIncomeAnnouncementsList(): ArrayList<ListOptionModel> =
        getAnnouncementsList(ApplicationStatus.INCOME)

    suspend fun getDoneAnnouncementsList(): ArrayList<ListOptionModel> =
        getAnnouncementsList(ApplicationStatus.DONE)

    suspend fun insertRequired(entity: AnnouncementProductEntity) =
        dao.insertRequired(entity)

    suspend fun getRequired(announcementId: Int) =
        dao.getRequired(announcementId)

}